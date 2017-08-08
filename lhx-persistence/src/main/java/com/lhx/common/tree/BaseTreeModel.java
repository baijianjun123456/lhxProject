package com.lhx.common.tree;

public class BaseTreeModel {
	
	//是否展开状态："closed","open"
	private String state = "";

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
