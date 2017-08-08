package com.lhx.system.dict.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.common.tree.DictTreeModel;
import com.lhx.system.dict.model.Dict;
import com.lhx.system.dict.model.DictQuery;

/**
 * 数据字典持久化接口；
 * @author liangshu
 */
public interface DictDao extends SuperDao,BaseDao<Dict,DictQuery> {
	
	public List<DictTreeModel> queryDictAllTree(Map<String, String> param);
	
	@MapKey("code")
	public Map<String,Dict> queryCacheDict(Map<String,String> param);
}
