package com.lhx.stock.market.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.stock.market.model.Market;
import com.lhx.stock.market.model.MarketQuery;

/**
 * 股票行情持久化接口；
 * @author liangshu
 */
public interface MarketDao extends SuperDao,BaseDao<Market,MarketQuery> {
	
	/**
	 * 根据股票代码查询时间列表；
	 * @param tcode：股票代码；
	 * @return
	 */
	public List<String> queryTimeList(String tcode);
	
	/**
	 * 根据股票代码查询行情数据
	 * @param tcode：股票代码；
	 * @return
	 */
	public List<String> queryListByTcode(String tcode);
	
}
