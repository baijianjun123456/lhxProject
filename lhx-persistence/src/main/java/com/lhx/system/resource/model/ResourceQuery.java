package com.lhx.system.resource.model;

import java.io.Serializable;
import com.lhx.common.mybatis.pagination.PageModel;


/**
 * 系统资源访问表定义模型；
 * @author liangshu
 */
public class ResourceQuery extends PageModel<Resource> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//名称；
	private String name;
	
	//状态；
	private String status;

	private String menuId;
	
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
	
	
	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

} 
