package com.lhx.stock.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lhx.system.service.constants.SystemConstants;
import com.lhx.stock.service.MarketManagerService;
import com.lhx.stock.tdIndex.dao.TDIndexDao;
import com.lhx.stock.tdIndex.model.PointData;
import com.lhx.stock.lineIndex.dao.LineIndexDao;
import com.lhx.stock.market.dao.MarketDao;
import com.lhx.stock.market.model.Market;
import com.lhx.stock.market.model.MarketQuery;
import com.lhx.stock.model.EchartModel;
import com.lhx.stock.model.Series;
import com.lhx.stock.model.XAxis;

@Service
public class MarketManagerServiceImpl implements MarketManagerService {
	
    @Autowired
	private MarketDao  marketDao;
    
    @Autowired
	private TDIndexDao  tDIndexDao;
    
    @Autowired
  	private LineIndexDao  lineIndexDao;
    
	@Override
	public boolean addMarket(Market market_) {
		marketDao.save(market_);
		return true;
	}

	@Override
	public boolean removeMarket(Market market_, boolean flag) {
		if(flag){
			marketDao.delete(market_.getId_());
		}
		else{
			market_.setStatus(SystemConstants.DELETE_STATE);
			marketDao.update(market_);
		}
		return true;
	}

	@Override
	public int updateMarket(Market market_) {
		
		return marketDao.update(market_);
	}
	
	public Market get(Market market_){
		List<Market> marketList = marketDao.queryList(market_);
		return (marketList == null || marketList.size() <= 0) ? null : marketList.get(0);
	}
	
	public List<Market> getList(Market market_){
		return marketDao.queryList(market_);
	}
	
	public List<Market> getListPage(MarketQuery marketQuery){
		return marketDao.queryListPage(marketQuery);
	}
	
	public Market get(String id_){
		return marketDao.query(id_);
	}

	@Override
	public EchartModel createModel(String tcode) {
		
		List<String> timex = marketDao.queryTimeList(tcode);
		XAxis xAxis = new XAxis(timex);
		
		Market qmarket = Market.newInstance(tcode);
		List<Market> marketList = marketDao.queryList(qmarket);
		 
		Series series = new Series(marketList);
		
		List<PointData> pointDataList  = tDIndexDao.queryMarkPoint(tcode);
		for(PointData pointData : pointDataList){
			pointData.setItemStyle();
		}
		
		List<Map<String,String>>  tdstList = lineIndexDao.queryListByType("1");
		
		EchartModel echartModel = new EchartModel(series,xAxis,pointDataList,tdstList,null);
		return echartModel;
	}

}
