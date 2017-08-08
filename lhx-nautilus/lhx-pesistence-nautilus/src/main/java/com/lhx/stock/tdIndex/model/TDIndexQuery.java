package com.lhx.stock.tdIndex.model;

import java.io.Serializable;
import com.lhx.common.mybatis.pagination.PageModel;


/**
 * TD指标定义模型；
 * @author liangshu
 */
public class TDIndexQuery extends PageModel<TDIndex> implements Serializable{

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
