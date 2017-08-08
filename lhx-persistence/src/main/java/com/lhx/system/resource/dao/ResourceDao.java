package com.lhx.system.resource.dao;

import java.util.List;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.system.resource.model.Resource;
import com.lhx.system.resource.model.ResourceQuery;

/**
 * 系统资源访问表持久化接口；
 * @author liangshu
 */
public interface ResourceDao extends SuperDao,BaseDao<Resource,ResourceQuery> {
	
	public List<String> queryRolesByUrl(String url);
	
}
