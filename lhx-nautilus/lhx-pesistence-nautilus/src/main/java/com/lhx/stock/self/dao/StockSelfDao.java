package com.lhx.stock.self.dao;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.stock.self.model.StockSelf;
import com.lhx.stock.self.model.StockSelfQuery;

/**
 * 自选股持久化接口；
 * @author liangshu
 */
public interface StockSelfDao extends SuperDao,BaseDao<StockSelf,StockSelfQuery> {
	
	public void deleteByTcode(StockSelf stockSelf);

}
