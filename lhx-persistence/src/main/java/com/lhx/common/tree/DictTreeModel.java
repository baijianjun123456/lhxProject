package com.lhx.common.tree;

import java.util.List;

public class DictTreeModel extends BaseTreeModel{
	
	//字典编码
	private String id;
	
	//字典名称
	private String text;
	
	//字典编码
	private String code;
	
	//字典父节点编码
	private String pCode;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	//字典值
	private String value;
	
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<DictTreeModel> getChildren() {
		return children;
	}

	public void setChildren(List<DictTreeModel> children) {
		this.children = children;
	}

	private List<DictTreeModel>  children;
	
	
}
