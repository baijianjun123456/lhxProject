package com.lhx.system.userRole.model;

import java.io.Serializable;

import com.lhx.common.mybatis.pagination.PageModel;


/**
 * 用户角色定义模型；
 * @author liangshu
 */
public class UserRoleQuery extends PageModel<UserRole> implements Serializable {

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
