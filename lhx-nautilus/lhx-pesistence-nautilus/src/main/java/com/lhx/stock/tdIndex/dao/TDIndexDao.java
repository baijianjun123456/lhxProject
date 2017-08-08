package com.lhx.stock.tdIndex.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.stock.tdIndex.model.PointData;
import com.lhx.stock.tdIndex.model.TDIndex;
import com.lhx.stock.tdIndex.model.TDIndexQuery;

/**
 * TD指标持久化接口；
 * @author liangshu
 */
public interface TDIndexDao extends SuperDao,BaseDao<TDIndex,TDIndexQuery> {
	
	@MapKey("seq")
	public Map<Integer,TDIndex> queryMarketTdIndex(String tcode);
	
	public void saveMore(Collection<TDIndex> list);
	
	public List<PointData> queryMarkPoint(String tcode);
}
