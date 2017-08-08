package com.lhx.system.resource.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;


/**
 * 系统资源访问表定义模型；
 * @author liangshu
 */
public class Resource extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//资源访问路径
	private String url;

	//菜单ID
	private String menuId;

	public static Resource newInstance(String id__){
		Resource resource = new Resource();
		resource.setId_(id__);
		return resource;
	}

	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url_){
		this.url = url_;
	}
	public String getMenuId(){
		return this.menuId;
	}
	public void setMenuId(String menuId_){
		this.menuId = menuId_;
	}

} 
