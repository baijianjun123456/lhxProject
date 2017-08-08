package com.lhx.stock.lineIndex.model;

import java.io.Serializable;
import com.lhx.common.mybatis.pagination.PageModel;


/**
 * TD指标线定义模型；
 * @author liangshu
 */
public class LineIndexQuery extends PageModel<LineIndex> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//名称；
	private String name;
	
	//状态；
	private String status;
	
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
