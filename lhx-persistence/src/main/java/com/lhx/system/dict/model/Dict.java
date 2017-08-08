package com.lhx.system.dict.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;


/**
 * 数据字典定义模型；
 * @author liangshu
 */
public class Dict extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//国际化（必输*）
	private String i18n;

	//值（必输*）
	private String value;

	//编码（必输*）
	private String code;

	//父节点编码（必输*）
	private String pcode;

	public static Dict newInstance(String id__,String i18n_,String name_,String value_,String code_,String pcode_,String status_){
		Dict dict = new Dict();
		dict.setId_(id__);
		dict.setI18n(i18n_);
		dict.setName(name_);
		dict.setValue(value_);
		dict.setCode(code_);
		dict.setPcode(pcode_);
		dict.setStatus(status_);
		return dict;
	}

	public String getI18n(){
		return this.i18n;
	}
	public void setI18n(String i18n_){
		this.i18n = i18n_;
	}
	public String getValue(){
		return this.value;
	}
	public void setValue(String value_){
		this.value = value_;
	}
	public String getCode(){
		return this.code;
	}
	public void setCode(String code_){
		this.code = code_;
	}
	public String getPcode(){
		return this.pcode;
	}
	public void setPcode(String pcode_){
		this.pcode = pcode_;
	}

} 
