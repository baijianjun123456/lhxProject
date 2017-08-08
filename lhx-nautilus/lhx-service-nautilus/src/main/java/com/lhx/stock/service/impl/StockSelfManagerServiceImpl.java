package com.lhx.stock.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.lhx.stock.service.StockSelfManagerService;
import com.lhx.stock.self.dao.StockSelfDao;
import com.lhx.stock.self.model.StockSelf;
import com.lhx.stock.self.model.StockSelfQuery;

@Service
public class StockSelfManagerServiceImpl implements StockSelfManagerService {
	
    @Autowired
	private StockSelfDao  stockSelfDao;
    
	@Override
	public boolean addStockSelf(StockSelf stockSelf_) {
		stockSelfDao.deleteByTcode(stockSelf_);
		stockSelfDao.save(stockSelf_);
		return true;
	}

	@Override
	public boolean removeStockSelf(StockSelf stockSelf_, boolean flag) {
		stockSelfDao.deleteByTcode(stockSelf_);
		return true;
	}

	@Override
	public int updateStockSelf(StockSelf stockSelf_) {
		
		return stockSelfDao.update(stockSelf_);
	}
	
	public StockSelf get(StockSelf stockSelf_){
		List<StockSelf> stockSelfList = stockSelfDao.queryList(stockSelf_);
		return (stockSelfList == null || stockSelfList.size() <= 0) ? null : stockSelfList.get(0);
	}
	
	public List<StockSelf> getList(StockSelf stockSelf_){
		return stockSelfDao.queryList(stockSelf_);
	}
	
	public List<StockSelf> getListPage(StockSelfQuery stockSelfQuery){
		return stockSelfDao.queryListPage(stockSelfQuery);
	}
	
	public StockSelf get(String id_){
		return stockSelfDao.query(id_);
	}
	
	/**
	 * 是否是自选股票
	 * @return
	 */
	public boolean isSelf(StockSelf stockSelf){
		boolean isSelf = false;
		List<StockSelf> stockSelfList =  stockSelfDao.queryList(stockSelf);
		if(!CollectionUtils.isEmpty(stockSelfList)){
			isSelf = true;
		}
		return isSelf;
	}

}
