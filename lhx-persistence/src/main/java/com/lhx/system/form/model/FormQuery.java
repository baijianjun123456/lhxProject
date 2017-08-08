package com.lhx.system.form.model;

import java.io.Serializable;
import com.lhx.common.mybatis.pagination.PageModel;


/**
 * 表单管理定义模型；
 * @author liangshu
 */
public class FormQuery extends PageModel<Form> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//名称；
	private String name;
	
	private String tableName;
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
} 
