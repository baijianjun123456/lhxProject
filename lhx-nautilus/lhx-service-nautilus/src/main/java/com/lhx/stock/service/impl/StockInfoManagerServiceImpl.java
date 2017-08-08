package com.lhx.stock.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lhx.system.service.constants.SystemConstants;
import com.lhx.stock.service.StockInfoManagerService;
import com.lhx.stock.info.dao.StockInfoDao;
import com.lhx.stock.info.model.StockInfo;
import com.lhx.stock.info.model.StockInfoQuery;

@Service
public class StockInfoManagerServiceImpl implements StockInfoManagerService {
	
    @Autowired
	private StockInfoDao  stockInfoDao;
    
	@Override
	public boolean addStockInfo(StockInfo stockInfo_) {
		stockInfoDao.save(stockInfo_);
		return true;
	}

	@Override
	public boolean removeStockInfo(StockInfo stockInfo_, boolean flag) {
		if(flag){
			stockInfoDao.delete(stockInfo_.getId_());
		}
		else{
			stockInfo_.setStatus(SystemConstants.DELETE_STATE);
			stockInfoDao.update(stockInfo_);
		}
		return true;
	}

	@Override
	public int updateStockInfo(StockInfo stockInfo_) {
		
		return stockInfoDao.update(stockInfo_);
	}
	
	public StockInfo get(StockInfo stockInfo_){
		List<StockInfo> stockInfoList = stockInfoDao.queryList(stockInfo_);
		return (stockInfoList == null || stockInfoList.size() <= 0) ? null : stockInfoList.get(0);
	}
	
	public List<StockInfo> getList(StockInfo stockInfo_){
		return stockInfoDao.queryList(stockInfo_);
	}
	
	public List<StockInfo> getListPage(StockInfoQuery stockInfoQuery){
		return stockInfoDao.queryListPage(stockInfoQuery);
	}
	
	public StockInfo get(String id_){
		return stockInfoDao.query(id_);
	}

}
