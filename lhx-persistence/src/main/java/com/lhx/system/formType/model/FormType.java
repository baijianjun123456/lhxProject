package com.lhx.system.formType.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;


/**
 * 表单分类定义模型；
 * @author liangshu
 */
public class FormType extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//分类编码（必输*）
	private String code;

	public static FormType newInstance(String id__,String code_,String name_,String status_){
		FormType formType = new FormType();
		formType.setId_(id__);
		formType.setCode(code_);
		formType.setName(name_);
		formType.setStatus(status_);
		return formType;
	}

	public String getCode(){
		return this.code;
	}
	public void setCode(String code_){
		this.code = code_;
	}

} 
