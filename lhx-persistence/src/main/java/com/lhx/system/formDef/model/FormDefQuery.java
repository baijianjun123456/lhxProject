package com.lhx.system.formDef.model;

import java.io.Serializable;
import com.lhx.common.mybatis.pagination.PageModel;


/**
 * 表单定义定义模型；
 * @author liangshu
 */
public class FormDefQuery extends PageModel<FormDef> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//表单名称；
	private String formName;
	
	//表单编码；
	private String formCode;
	
	private String status;
	
	//表单类别；
	private String formType;

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}
	

} 
