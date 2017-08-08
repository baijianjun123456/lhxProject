package com.lhx.system.role.dao;

import java.util.List;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.system.role.model.Role;
import com.lhx.system.role.model.RoleQuery;

/**
 * 角色管理持久化接口；
 * @author liangshu
 */
public interface RoleDao extends SuperDao,BaseDao<Role,RoleQuery> {
	
	/**
	 * 根据当前用户ID查询已选择的角色列表
	 * @param userId：用户ID
	 * @return
	 */
	public List<Role> selectedRoleList(String userId);
	
	/**
	 * 根据当前用户ID查询未选择的角色列表
	 * @param userId：用户ID
	 * @return
	 */
	public List<Role> notSelectRoleList(String userId);
}
