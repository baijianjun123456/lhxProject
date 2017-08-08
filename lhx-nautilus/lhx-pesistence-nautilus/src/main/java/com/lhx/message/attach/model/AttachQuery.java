package com.lhx.message.attach.model;

import java.io.Serializable;
import com.lhx.common.mybatis.pagination.PageModel;
import java.sql.Date;


/**
 * 附件表定义模型；
 * @author liangshu
 */
public class AttachQuery extends PageModel<Attach> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//名称；
	private String name;
	
	//状态；
	private String isdel;
	
	public String getIsDel() {
		return isdel;
	}

	public void setIsDel(String isdel) {
		this.isdel = isdel;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
} 
