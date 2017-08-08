package com.lhx.common.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.file.model.TabColModel;

/**
 * 表列定义的持久化接口；
 * @author lliangshu
 *
 */
public interface TabColDao extends SuperDao,BaseDao<TabColModel,TabColModel> {
	
	//查询数据库表列表；
	public List<Map<String,String>>  queryTableList();
	
	//根据表名查询列定义列表
	public List<TabColModel> queryFiledList(String tableName);
		
}
