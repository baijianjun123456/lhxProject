package com.lhx.common.mybatis;

import java.io.Serializable;

/**
 * 基础实体类
 * @author liangshu
 *
 */
public class BaseModel implements Serializable{
	
	private static final long serialVersionUID = -5009851901691928055L;
	

	//ID；
	private String id_;	

	//名称；
	private String name;

	//创建时间；
	private String createt;
	
	//创建人ID；
	private String createp;
	
	//状态；
	private String status;
	
	//private String stautsName;
	
	public BaseModel(){
		
	}

	public BaseModel(String id_){
		this.setId_(id_);
	}
	
	public BaseModel(String id_,String name_){
		this(id_);
		this.setName(name_);
	}
	
	public String getId_() {
		return id_;
	}

	public void setId_(String id) {
		this.id_ = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getCreatet() {
		return createt;
	}

	public void setCreatet(String createt) {
		this.createt = createt;
	}

	public String getCreatep() {
		return createp;
	}

	public void setCreatep(String createp) {
		this.createp = createp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
