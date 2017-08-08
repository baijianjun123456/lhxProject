package com.lhx.system.userOrg.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;


/**
 * 用户组织机构定义模型；
 * @author liangshu
 */
public class UserOrg extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//机构ID
	private String orgId;

	//用户展示名称
	private String showName;

	//排序
	private String orderBy;

	public static UserOrg newInstance(String id__,String orgId_,String showName_){
		UserOrg userOrg = new UserOrg();
		userOrg.setId_(id__);
		userOrg.setOrgId(orgId_);
		userOrg.setShowName(showName_);
		return userOrg;
	}

	public String getOrgId(){
		return this.orgId;
	}
	public void setOrgId(String orgId_){
		this.orgId = orgId_;
	}
	public String getShowName(){
		return this.showName;
	}
	public void setShowName(String showName_){
		this.showName = showName_;
	}
	public String getOrderBy(){
		return this.orderBy;
	}
	public void setOrderBy(String orderBy_){
		this.orderBy = orderBy_;
	}

} 
