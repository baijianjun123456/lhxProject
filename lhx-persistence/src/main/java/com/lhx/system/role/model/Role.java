package com.lhx.system.role.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;


/**
 * 角色管理定义模型；
 * @author liangshu
 */
public class Role extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//角色名称全拼
	private String nameSpell;

	//机构ID
	private String orgId;

	//机构层级码
	private String orgLevel;

	//机构识别码
	private String orgIdenty;

	//角色描述
	private String desc_;

	//角色编码（必输*）
	private String code;

	public static Role newInstance(String id__,String name_,String status_,String code_){
		Role role = new Role();
		role.setId_(id__);
		role.setName(name_);
		role.setStatus(status_);
		role.setCode(code_);
		return role;
	}

	public String getNameSpell(){
		return this.nameSpell;
	}
	public void setNameSpell(String nameSpell_){
		this.nameSpell = nameSpell_;
	}
	public String getOrgId(){
		return this.orgId;
	}
	public void setOrgId(String orgId_){
		this.orgId = orgId_;
	}
	public String getOrgLevel(){
		return this.orgLevel;
	}
	public void setOrgLevel(String orgLevel_){
		this.orgLevel = orgLevel_;
	}
	public String getOrgIdenty(){
		return this.orgIdenty;
	}
	public void setOrgIdenty(String orgIdenty_){
		this.orgIdenty = orgIdenty_;
	}
	public String getDesc_(){
		return this.desc_;
	}
	public void setDesc_(String desc__){
		this.desc_ = desc__;
	}
	public String getCode(){
		return this.code;
	}
	public void setCode(String code_){
		this.code = code_;
	}

} 
