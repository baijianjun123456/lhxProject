package com.lhx.stock.lineIndex.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.stock.lineIndex.model.LineIndex;
import com.lhx.stock.lineIndex.model.LineIndexQuery;

/**
 * TD指标线持久化接口；
 * @author liangshu
 */
public interface LineIndexDao extends SuperDao,BaseDao<LineIndex,LineIndexQuery> {
	
	public void saveMore(Collection<LineIndex> list);
	
	public List<Map<String,String>> queryListByType(String type);

}
