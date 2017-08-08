package com.lhx.system.service.entity;

import java.util.ArrayList;
import java.util.List;
import com.lhx.system.org.model.Org;
import com.lhx.system.resource.model.Resource;
import com.lhx.system.role.model.Role;
import com.lhx.system.user.model.User;

public class UserLoginInfo {
	
	public String userId ;
	
	public User user;
	
	public Org org;
	
	public List<Role> roleList = new ArrayList<Role>();
	
	public List<Resource> resourceList = new ArrayList<>();
	
	public static UserLoginInfo newInstance(User user,Org org,List<Role> roleList,List<Resource> resourceList){
		UserLoginInfo userLoginInfo = new UserLoginInfo();
		userLoginInfo.setUserId(user.getId_());
		userLoginInfo.setUser(user);
		userLoginInfo.setOrg(org);
		userLoginInfo.setRoleList(roleList);
		userLoginInfo.setResourceList(resourceList);
		return userLoginInfo;
	}
	
	public List<Resource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}

	public void addRole(Role role){
		roleList.add(role);
	}
	
	public boolean isContainRole(String roleId){
		boolean isContain = false;
		if(roleList != null){
			for(Role role : this.roleList ){
				if(roleId.equals(role.getId_())){
					isContain = true;
				}
			}
		}
		return isContain;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	

}
