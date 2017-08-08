package com.lhx.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lhx.system.service.constants.SystemConstants;
import com.lhx.system.service.RoleManagerService;
import com.lhx.system.userRole.dao.UserRoleDao;
import com.lhx.system.userRole.model.UserRole;
import com.lhx.system.role.dao.RoleDao;
import com.lhx.system.role.model.Role;
import com.lhx.system.role.model.RoleQuery;
import com.lhx.system.roleMenu.dao.RoleMenuDao;
import com.lhx.system.roleMenu.model.RoleMenu;

@Service
public class RoleManagerServiceImpl implements RoleManagerService {
	
	private static final String  NOT_SELECT = "NOT_SELECT";
	
	private static final String  SELECTD= "SELECTD";
		
    @Autowired
	private RoleDao  roleDao;
    
    @Autowired
	private UserRoleDao  userRoleDao;
    
    @Autowired
	private RoleMenuDao  roleMenuDao;
    
	@Override
	public boolean addRole(Role role_) {
		roleDao.save(role_);
		return true;
	}

	@Override
	public boolean removeRole(Role role_, boolean flag) {
		if(flag){
			roleDao.delete(role_.getId_());
		}
		else{
			role_.setStatus(SystemConstants.DELETE_STATE);
			roleDao.update(role_);
		}
		return true;
	}

	@Override
	public int updateRole(Role role_) {
		
		return roleDao.update(role_);
	}
	
	public Role get(Role role_){
		List<Role> roleList = roleDao.queryList(role_);
		return (roleList == null || roleList.size() <= 0) ? null : roleList.get(0);
	}
	
	public List<Role> getList(Role role_){
		return roleDao.queryList(role_);
	}
	
	public List<Role> getListPage(RoleQuery roleQuery){
		return roleDao.queryListPage(roleQuery);
	}
	
	public Role get(String id_){
		return roleDao.query(id_);
	}
	
	/**
	 *根据用户ID查询选中或未选中的角色列表；
	 * @param userId ： 用户列表
	 * @param type ： 1 ：未选中，2：已选中 ，3 ： all
	 * @return
	 */
	public Map<String,List<Role>> getNotOrSelectRole(String userId,String type){
		Map<String,List<Role>> rolesMap = new HashMap<String,List<Role>>();
		if(NOT_SELECT.equals(type)){
			rolesMap.put(NOT_SELECT, roleDao.notSelectRoleList(userId));
		}
		else if(SELECTD.equals(type)){
			rolesMap.put(SELECTD, roleDao.selectedRoleList(userId));
		}
		else{
			rolesMap.put(NOT_SELECT, roleDao.notSelectRoleList(userId));
			rolesMap.put(SELECTD, roleDao.selectedRoleList(userId));
		}
		return rolesMap;
	}
	
	/**
	 * 保存用户角色列表；
	 * @param userRoles ： 用户角色列表信息；
	 */
	public void saveUserRoles(List<UserRole> userRoles){
		if(!CollectionUtils.isEmpty(userRoles)){
			userRoleDao.deleteByUserId(userRoles.get(0).getUserId());
			userRoleDao.saveMore(userRoles);
		}
	}
	
	/**
	 * 保存角色菜单关系信息；
	 * @param roleMenus
	 */
	public void saveRoleMenuList(List<RoleMenu> roleMenus){
		this.roleMenuDao.delete(roleMenus.get(0).getRoleId());
		this.roleMenuDao.saveMore(roleMenus);
	}
}
