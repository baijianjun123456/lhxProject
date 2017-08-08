package com.lhx.system.org.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;


/**
 * 组织机构定义模型；
 * @author liangshu
 */
public class Org extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//上级机构ID
	private String pid;

	//部门机构标识(1：机构；0部门)
	private String flag;

	//机构/部门名称全拼
	private String spell;

	//机构层级码
	private String level_;

	//机构识别码
	private String identy;

	//排序
	private String orderBy;

	public static Org newInstance(String id__,String flag_,String name_,String level__,String identy_){
		Org org = new Org();
		org.setId_(id__);
		org.setFlag(flag_);
		org.setName(name_);
		org.setLevel_(level__);
		org.setIdenty(identy_);
		return org;
	}

	public String getPid(){
		return this.pid;
	}
	public void setPid(String pid_){
		this.pid = pid_;
	}
	public String getFlag(){
		return this.flag;
	}
	public void setFlag(String flag_){
		this.flag = flag_;
	}
	public String getSpell(){
		return this.spell;
	}
	public void setSpell(String spell_){
		this.spell = spell_;
	}
	public String getLevel_(){
		return this.level_;
	}
	public void setLevel_(String level__){
		this.level_ = level__;
	}
	public String getIdenty(){
		return this.identy;
	}
	public void setIdenty(String identy_){
		this.identy = identy_;
	}
	public String getOrderBy(){
		return this.orderBy;
	}
	public void setOrderBy(String orderBy_){
		this.orderBy = orderBy_;
	}

} 
