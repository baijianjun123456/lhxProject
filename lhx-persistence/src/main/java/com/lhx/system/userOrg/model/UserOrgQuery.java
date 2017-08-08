package com.lhx.system.userOrg.model;

import java.io.Serializable;

import com.lhx.common.mybatis.pagination.PageModel;


/**
 * 用户组织机构定义模型；
 * @author liangshu
 */
public class UserOrgQuery extends PageModel<UserOrg> implements Serializable {

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
