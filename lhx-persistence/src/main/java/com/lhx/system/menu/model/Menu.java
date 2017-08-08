package com.lhx.system.menu.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;


/**
 * 菜单定义模型；
 * @author liangshu
 */
public class Menu extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//父菜单
	private String pid;

	//菜单名称全拼
	private String nameSpell;

	//菜单编码（必输*）
	private String code;

	//菜单URL
	private String url;

	//菜单级别(1:显示一级菜单；2：显示为二级菜单)（必输*）
	private String level_;

	//菜单图标
	private String ico;

	//排序
	private String orderBy;

	public static Menu newInstance(String id__,String name_,String code_,String level__){
		Menu menu = new Menu();
		menu.setId_(id__);
		menu.setName(name_);
		menu.setCode(code_);
		menu.setLevel_(level__);
		return menu;
	}

	public String getPid(){
		return this.pid;
	}
	public void setPid(String pid_){
		this.pid = pid_;
	}
	public String getNameSpell(){
		return this.nameSpell;
	}
	public void setNameSpell(String nameSpell_){
		this.nameSpell = nameSpell_;
	}
	public String getCode(){
		return this.code;
	}
	public void setCode(String code_){
		this.code = code_;
	}
	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url_){
		this.url = url_;
	}
	public String getLevel_(){
		return this.level_;
	}
	public void setLevel_(String level__){
		this.level_ = level__;
	}
	public String getIco(){
		return this.ico;
	}
	public void setIco(String ico_){
		this.ico = ico_;
	}
	public String getOrderBy(){
		return this.orderBy;
	}
	public void setOrderBy(String orderBy_){
		this.orderBy = orderBy_;
	}

} 
