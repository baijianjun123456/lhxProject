package com.lhx.stock.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.lhx.stock.lineIndex.model.LineIndex;
import com.lhx.stock.tdIndex.model.TDIndex;

public class TDIndexLineHanlder {
	
	//止盈线列表；
    List<LineIndex> tDIndexLineList = new ArrayList<LineIndex>();
    
    Map<String,List<TDIndex>> stStructMap = new LinkedHashMap<String,List<TDIndex>>();
    
    int structIndex = -1;
    
    //当前ST趋势；
  	String curSTTrend = "";
  	
  	public void recodeStStruct(TDIndex tDIndex,int ST_Count,String type){
  		if(ST_Count == 1){
  			List<TDIndex> stStruct = new ArrayList<TDIndex>();
  			stStruct.add(tDIndex);
  			curSTTrend = "UP";
  			stStructMap.put(curSTTrend+"_"+tDIndex.getTcode()+"_"+(++structIndex), stStruct);
  		}
  		else if(ST_Count == 101){
  			List<TDIndex> stStruct = new ArrayList<TDIndex>();
  			stStruct.add(tDIndex);
  			curSTTrend = "DOWN";
  			stStructMap.put(curSTTrend+"_"+tDIndex.getTcode()+"_"+(++structIndex), stStruct);
  		}
  		else{
  			List<TDIndex> stStruct = stStructMap.get(curSTTrend+"_"+tDIndex.getTcode()+"_"+(structIndex));
  			if(stStruct != null){
  	  			stStruct.add(tDIndex);
  			}
  		}
  	}
  	
  	public void createDIndexLine(){
  		Set<String> keys = stStructMap.keySet();
  		int index = 0;
  		for(String key : keys){
  			List<TDIndex> stStruct = stStructMap.get(key);

  			if(index == 0){	
  				LineIndex tDIndexLine  = new LineIndex(key,key.split("_")[0],"1");
  	  		    tDIndexLineList.add(tDIndexLine);
	  	  		for(TDIndex tDIndex : stStruct){
	  				tDIndexLine.setyYValue(tDIndex.getOpen());
	  				tDIndexLine.setXtimes(tDIndex.getTime());
	  			}
  			}
  			else{
  				LineIndex tDIndexLinePre = tDIndexLineList.get(tDIndexLineList.size()-1);
  				LineIndex tDIndexLine  = new LineIndex(key,key.split("_")[0],"1");
  	  		    tDIndexLineList.add(tDIndexLine);
	  	  		for(TDIndex tDIndex : stStruct){
	  				tDIndexLinePre.setyYValue(tDIndex.getOpen());
	  				tDIndexLinePre.setXtimes(tDIndex.getTime());

	  				tDIndexLine.setyYValue(tDIndex.getOpen());
	  				tDIndexLine.setXtimes(tDIndex.getTime());

	  			}
  			}
  			++index;
  		
  		}
  	}
  	
} 
