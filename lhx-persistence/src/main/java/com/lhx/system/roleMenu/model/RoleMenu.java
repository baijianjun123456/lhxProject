package com.lhx.system.roleMenu.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;


/**
 * 角色菜单定义模型；
 * @author liangshu
 */
public class RoleMenu extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//角色ID
	private String roleId;

	//菜单ID
	private String menuId;

	public static RoleMenu newInstance(String id__,String roleId_,String menuId_){
		RoleMenu roleMenu = new RoleMenu();
		roleMenu.setId_(id__);
		roleMenu.setRoleId(roleId_);
		roleMenu.setMenuId(menuId_);
		return roleMenu;
	}

	public String getRoleId(){
		return this.roleId;
	}
	public void setRoleId(String roleId_){
		this.roleId = roleId_;
	}
	public String getMenuId(){
		return this.menuId;
	}
	public void setMenuId(String menuId_){
		this.menuId = menuId_;
	}

} 
