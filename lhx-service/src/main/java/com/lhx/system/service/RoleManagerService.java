package com.lhx.system.service;

import java.util.List;
import java.util.Map;

import com.lhx.system.role.model.Role;
import com.lhx.system.role.model.RoleQuery;
import com.lhx.system.roleMenu.model.RoleMenu;
import com.lhx.system.userRole.model.UserRole;

/**
 * 角色管理管理相关服务接口
 * @author liangshu
 *
 */
public interface RoleManagerService {
	
	/**
	 * 添加新角色管理；
	 * @param user：新增角色管理目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addRole(Role role_);
	
	/**
	 * 删除角色管理；
	 * @param user_:删除目标角色管理对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removeRole(Role role_,boolean flag);
	
	/**
	 * 更新角色管理信息；
	 * @param user_：更新目标角色管理对象信息；
	 * @return : 被更新角色管理的总条数
	 */ 
	public  int  updateRole(Role role_);
	
	public List<Role> getList(Role role);

	/**
	 * 查询角色管理列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<Role> getListPage(RoleQuery roleQuery);
	
	
	public Role get(String id_);
	
	/**
	 *根据用户ID查询选中或未选中的角色列表；
	 * @param userId ： 用户列表
	 * @param type ： 1 ：未选中，2：已选中 ，3 ： all
	 * @return
	 */
	public Map<String,List<Role>> getNotOrSelectRole(String userId,String type);
	
	/**
	 * 保存用户角色列表；
	 * @param userRoles ： 用户角色列表信息；
	 */
	public void saveUserRoles(List<UserRole> userRoles);
	
	/**
	 * 保存角色菜单关系信息；
	 * @param roleMenus
	 */
	public void saveRoleMenuList(List<RoleMenu> roleMenus);
}
