package com.lhx.system.user.model;

import java.io.Serializable;

import com.lhx.common.mybatis.pagination.PageModel;


/**
 * 用户定义模型；
 * @author liangshu
 */
public class UserQuery extends PageModel<User> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//姓名；
	private String name;
	
	//账号；
	private String accounts;
	
	//邮箱；
	private String email;
	
	//手机；
	private String mobile;
	
	//手机；
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
} 
