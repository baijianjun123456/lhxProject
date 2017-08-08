package com.lhx.system.roleMenu.model;

import java.io.Serializable;

import com.lhx.common.mybatis.BaseModel;
import com.lhx.common.mybatis.pagination.PageModel;


/**
 * 角色菜单定义模型；
 * @author liangshu
 */
public class RoleMenuQuery extends PageModel<RoleMenu> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//名称；
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
} 
