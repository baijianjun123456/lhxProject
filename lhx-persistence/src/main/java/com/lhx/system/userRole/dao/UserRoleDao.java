package com.lhx.system.userRole.dao;

import java.util.List;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.system.userRole.model.UserRole;
import com.lhx.system.userRole.model.UserRoleQuery;

/**
 * 用户角色持久化接口；
 * @author liangshu
 */
public interface UserRoleDao extends SuperDao,BaseDao<UserRole,UserRoleQuery> {
	
	public void saveMore(List<UserRole> list);
	
	public void deleteByUserId(String userId);

}
