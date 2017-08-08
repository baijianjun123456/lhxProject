package com.lhx.system.userRole.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;


/**
 * 用户角色定义模型；
 * @author liangshu
 */
public class UserRole extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//用户ID
	private String userId;

	//角色ID
	private String roleId;

	//排序
	private String orderBy;

	public static UserRole newInstance(String id__,String userId_,String roleId_){
		UserRole userRole = new UserRole();
		userRole.setId_(id__);
		userRole.setUserId(userId_);
		userRole.setRoleId(roleId_);
		return userRole;
	}

	public String getUserId(){
		return this.userId;
	}
	public void setUserId(String userId_){
		this.userId = userId_;
	}
	public String getRoleId(){
		return this.roleId;
	}
	public void setRoleId(String roleId_){
		this.roleId = roleId_;
	}
	public String getOrderBy(){
		return this.orderBy;
	}
	public void setOrderBy(String orderBy_){
		this.orderBy = orderBy_;
	}

} 
