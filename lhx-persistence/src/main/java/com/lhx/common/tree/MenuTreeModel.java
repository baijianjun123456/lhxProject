package com.lhx.common.tree;

import java.util.List;

public class MenuTreeModel  extends BaseTreeModel{
	
	private String id;
	
	private String text;

	private boolean checked;
	
	private String roleId;
	
	private List<MenuTreeModel>  children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<MenuTreeModel> getChildren() {
		return children;
	}

	public void setChildren(List<MenuTreeModel> children) {
		this.children = children;
	}
	
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
