package com.lhx.system.org.model;

import java.io.Serializable;
import com.lhx.common.mybatis.pagination.PageModel;


/**
 * 组织机构定义模型；
 * @author liangshu
 */
public class OrgQuery extends PageModel<Org> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//名称；
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
} 
