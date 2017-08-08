package com.lhx.system.formDef.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;


/**
 * 表单定义定义模型；
 * @author liangshu
 */
public class FormDef extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//表单名称（必输*）
	private String formName;

	//表单分类（必输*）
	private String formType;

	//表单描述
	private String formDesc;

	//表单编码（必输*）
	private String formCode;

	public static FormDef newInstance(String id__,String formName_,String formType_,String formCode_){
		FormDef formDef = new FormDef();
		formDef.setId_(id__);
		formDef.setFormName(formName_);
		formDef.setFormType(formType_);
		formDef.setFormCode(formCode_);
		return formDef;
	}

	public String getFormName(){
		return this.formName;
	}
	public void setFormName(String formName_){
		this.formName = formName_;
	}
	public String getFormType(){
		return this.formType;
	}
	public void setFormType(String formType_){
		this.formType = formType_;
	}
	public String getFormDesc(){
		return this.formDesc;
	}
	public void setFormDesc(String formDesc_){
		this.formDesc = formDesc_;
	}
	public String getFormCode(){
		return this.formCode;
	}
	public void setFormCode(String formCode_){
		this.formCode = formCode_;
	}

} 
