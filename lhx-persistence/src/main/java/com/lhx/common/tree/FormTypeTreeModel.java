package com.lhx.common.tree;

import java.util.List;

public class FormTypeTreeModel extends BaseTreeModel{
	
	private String id;
	
	private String text;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FormTypeTreeModel getpCode() {
		return pCode;
	}

	public void setpCode(FormTypeTreeModel pCode) {
		this.pCode = pCode;
	}

	private FormTypeTreeModel pCode;
		

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private List<FormTypeTreeModel>  children;

	public List<FormTypeTreeModel> getFormTypeTreeModelList() {
		return children;
	}

	public void setFormTypeTreeModelList(
			List<FormTypeTreeModel> formTypeTreeModelList) {
		this.children = formTypeTreeModelList;
	}

	

}
