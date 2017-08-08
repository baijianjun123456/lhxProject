package com.lhx.stock.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.lhx.stock.lineIndex.dao.LineIndexDao;
import com.lhx.stock.service.IndexManagerService;
import com.lhx.stock.tdIndex.dao.TDIndexDao;
import com.lhx.stock.tdIndex.model.TDIndex;
import com.lhx.utils.StringUtil;

public class TDIndexManagerServiceImpl implements IndexManagerService {
	
    @Autowired
	private TDIndexDao  tDIndexDao;
    
    @Autowired
    private LineIndexDao lineIndexDao;
    
    private TDIndexLineHanlder indexLineHanlder = new TDIndexLineHanlder();
    
    private Map<Integer,TDIndex> tDIndexMap = null;
    
    //完成的ST结构集合
    private List<List<String>>  doneSTList = null;
    
    //当前CD计数集合；
    private Map<Integer,TDIndex> currentCDMap = null;
    
    //当前CD计数对应的ST结构信息；
    private List<String> currentST = null;

	@Override
	public void calculate(Map<String, String> param) {
		
		init();
		
		tDIndexMap =  tDIndexDao.queryMarketTdIndex(param.get("tcode"));
		
		tDIndexMap = sortMapByKey(tDIndexMap);
		
		this.calculate(tDIndexMap,param);
		
		tDIndexDao.saveMore(tDIndexMap.values());
		
		lineIndexDao.saveMore(indexLineHanlder.tDIndexLineList);

	}
	
	private void init(){
		
		doneSTList = new ArrayList<List<String>>();
		
		currentST = null;
		
		tDIndexMap = null;
		
		currentCDMap = new HashMap<Integer,TDIndex>();
	}
	
	private  List<TDIndex> calculate(Map<Integer,TDIndex> tDIndexMap,Map<String, String> param){
		List<TDIndex> resultTDIndexList = new ArrayList<TDIndex>();
		
		
		
		int ST_Count = 0;
		int CD_Count = 0;
		
		for(Integer seq : tDIndexMap.keySet()){
			if(seq > 4){
				TDIndex tDIndex = tDIndexMap.get(seq);
				
				//设置ST计数；
				ST_Count = this.setSTCount(tDIndex,ST_Count);
				
				//设置CD计数；
				CD_Count = this.setCDCount(tDIndex, CD_Count);
			}
					
		}
		
		//设置止盈线；
		this.setTDST();
		
		return resultTDIndexList;
	}
	
	
	/**
	 * 设置止盈线
	 */
	private void setTDST(){
		
		for(TDIndex tDIndex : tDIndexMap.values()){
			int stCount = tDIndex.getStCount();
			//if(tDIndex.getStCount() != -999 && tDIndex.getStCount() != 0){
				indexLineHanlder.recodeStStruct(tDIndex, stCount, "TDST");
			//}
			
		}
		
		indexLineHanlder.createDIndexLine();
	}
	
	/**
	 * 设置止损线
	 *//*
	private void setSTOP(List<LineIndex> TDIndexLine){
		
	}*/
	
	
	/**
	 * 设置ST计数
	 * @param tDIndex : 当天股票股价信息；
	 * @param ST_Count ： 当前ST计数值；
	 */
	private int setSTCount(TDIndex tDIndex,int ST_Count){
		
		//前四天的股价信息；
		TDIndex tDIndex4 = tDIndexMap.get(tDIndex.getSeq()-4);
		
		//前一天的股价信息；
		TDIndex tDIndex1 = tDIndexMap.get(tDIndex.getSeq()-1);
		
		//TD卖出结构（上升趋势）;
		if(tDIndex.getClose() > tDIndex4.getClose()){
			
			
			if(ST_Count>0 && ST_Count<100){ //昨天卖出结构
				ST_Count++;					
			}else if(ST_Count>100 && ST_Count<109){ //趋势反转，ST计数未超过109；昨天买入结构
				this.clearSTCount(tDIndex, ST_Count); //ST买入计数未超过109则清空之前的计数,从1开始重新计数；
				ST_Count=1;
			}else if(ST_Count>=109){ //趋势反转,ST计数超过109； 昨天买入结构s
				this.recordBP(tDIndex1,ST_Count); //记录拐点信息；
				ST_Count=1;
			}else if(ST_Count == 0){ 
				this.clearSTCount(tDIndex, ST_Count);
				ST_Count = 1;
			}
		}
		
		//TD买入结构（下降趋势）;
		else if(tDIndex.getClose() < tDIndex4.getClose()){

			if(ST_Count>100){ //昨天买入结构
				ST_Count++;
			}else if(ST_Count > 0 && ST_Count < 9){ //趋势反转，ST计数未超过9；//昨天卖出结构
				this.clearSTCount(tDIndex, ST_Count); //ST卖出计数未超过9则清空之前的计数；从101开始重新计数；
				ST_Count=101;
			}else if(ST_Count>=9 && ST_Count<100){ //趋势反转,ST计数超过9；/昨天卖出结构
				this.recordBP(tDIndex1,ST_Count); //记录拐点信息；
				ST_Count = 101;
			}else if(ST_Count == 0){
				this.clearSTCount(tDIndex, ST_Count);
				ST_Count = 101;
			}
		}
		
		//相等情况，中断重新计数
		else if(tDIndex.getClose() == tDIndex4.getClose()){
			if(ST_Count > 0 && ST_Count % 100 <9){
				this.clearSTCount(tDIndex, ST_Count); //ST买入计数未超过109，卖出计数未超过9则清空之前的计数，从新开始计数；
				ST_Count = 0;
			}else if(ST_Count % 100 >= 9){
				this.recordBP(tDIndex1,ST_Count); //记录拐点信息；
				ST_Count = 0;
			}
		}
		
		if(ST_Count != 0){
			tDIndex.setStCount(ST_Count);
		}
		
		return ST_Count;
	}
	
	/**
	 * TD计数未完成则清空之前的计数；
	 * @param tDIndex：
	 * @param ST_Count : 当前ST计数；
	 */
	private void clearSTCount(TDIndex tDIndex,int ST_Count){
		int seq = tDIndex.getSeq();
		if(ST_Count > 100){
			ST_Count = ST_Count - 100;
		}
		for(int i = ST_Count+1 ; i > 0; --i){
			this.tDIndexMap.get(seq-i).setStCount(-999);
		}
	}
	
	/**
	 * 设置趋势拐点信息；
	 * @param tDIndex : 昨天TD信息；
	 * @param ST_Count
	 */
	private void recordBP(TDIndex tDIndex,int ST_Count){
		
		List<String> doneST = new ArrayList<String>();
		if(ST_Count >= 109){
			tDIndex.setStBp(tDIndex.getTime());
			tDIndex.setStTrend("DOWN");
			doneST.add(tDIndex.getId_());
			doneST.add("DOWN");
		}
		if(ST_Count >= 9 && ST_Count <= 100){
			tDIndex.setStBp(tDIndex.getTime());
			tDIndex.setStTrend("UP");
			doneST.add(tDIndex.getId_());
			doneST.add("UP");
		}
		doneSTList.add(doneST);
	}
	
	/**
	 * 设置CD计数；
	 * @param tDIndex
	 * @param CD_Count
	 */
	private int setCDCount(TDIndex tDIndex,int CD_Count){
		
		//设置当前ST完成结构；
		if(CollectionUtils.isEmpty(setCurrentDoneST())){
			return 0;
		}
		
		//CD结构对应ST结构ID;
		String cdPhaseId = this.currentST.get(0);
				
		//趋势
		String stTrend = this.currentST.get(1);
		
		//前两天的股价信息；
		TDIndex tDIndex2 = tDIndexMap.get(tDIndex.getSeq()-2);
		
		String displayCotent = "";
		
		//当天为卖出结构；
		if(tDIndex.getClose() > tDIndex2.getHigh()){
			
			//卖出结构
			if("UP".equals(stTrend)){
				if( CD_Count < 12){
					CD_Count++ ;
					currentCDMap.put(CD_Count, tDIndex);
				}
				else if(CD_Count == 12){
					TDIndex tDIndexD8 = currentCDMap.get(8);
					if(tDIndex.getHigh() >= tDIndexD8.getClose()){
						CD_Count = 13;
					}
					else if(tDIndex.getHigh() < tDIndexD8.getClose()){
						displayCotent = "+";
					}
				}
				
				if(StringUtil.isBlank(displayCotent)){
					displayCotent = CD_Count+"";
				}
				tDIndex.setCdBp("UP");
				tDIndex.setCdCount(CD_Count);
				tDIndex.setDisplayContent(displayCotent);
				tDIndex.setCdPhaseId(cdPhaseId);
		      }
		
		//当天为买入结构；
		}else if(tDIndex.getClose() <= tDIndex2.getHigh()){
			if("DOWN".equals(stTrend)){
				if( CD_Count < 12){
					CD_Count++ ;
					currentCDMap.put(CD_Count, tDIndex);
				}
				else if(CD_Count == 12){
					TDIndex tDIndexD8 = currentCDMap.get(8);
					if(tDIndex.getHigh() <= tDIndexD8.getClose()){
						CD_Count = 13;
					}
					else if(tDIndex.getHigh() > tDIndexD8.getClose()){
						displayCotent = "+";
					}
				}
				
				if(StringUtil.isBlank(displayCotent)){
					displayCotent = CD_Count+"";
				}
				tDIndex.setCdBp("DOWN");
				tDIndex.setCdCount(CD_Count);
				tDIndex.setDisplayContent(displayCotent);
				tDIndex.setCdPhaseId(cdPhaseId);
			}
		}
		
		if(CD_Count == 13){
			CD_Count = 0;
		}
		return CD_Count;
	}
	
	private List<String> setCurrentDoneST(){
		if(!CollectionUtils.isEmpty(doneSTList)){
			this.currentST = doneSTList.get(doneSTList.size()-1);
			doneSTList.remove(this.currentST);
		}
		return this.currentST;
	}
	
	 /**
     * 使用 Map按key进行排序
     * @param map
     * @return
     */
    private static Map<Integer, TDIndex> sortMapByKey(Map<Integer, TDIndex> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<Integer, TDIndex> sortMap = new TreeMap<Integer, TDIndex>(new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }
    
	static class MapKeyComparator implements Comparator<Integer>{

	    @Override
	    public int compare(Integer str1, Integer str2) {

	        return str1.compareTo(str2);
	    }
	}
   
}
