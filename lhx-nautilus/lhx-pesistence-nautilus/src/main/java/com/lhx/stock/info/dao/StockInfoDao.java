package com.lhx.stock.info.dao;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.stock.info.model.StockInfo;
import com.lhx.stock.info.model.StockInfoQuery;

/**
 * 股票基础信息表持久化接口；
 * @author liangshu
 */
public interface StockInfoDao extends SuperDao,BaseDao<StockInfo,StockInfoQuery> {

}
