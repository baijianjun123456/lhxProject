package com.lhx.system.menu.model;

import java.io.Serializable;
import com.lhx.common.mybatis.pagination.PageModel;


/**
 * 菜单定义模型；
 * @author liangshu
 */
public class MenuQuery extends PageModel<Menu> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//名称；
	private String name;
	
	//状态；
	private String status;
	
	//状态；
	private String pid;
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
} 
