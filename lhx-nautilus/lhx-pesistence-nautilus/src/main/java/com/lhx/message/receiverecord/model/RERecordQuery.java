package com.lhx.message.receiverecord.model;

import java.io.Serializable;
import com.lhx.common.mybatis.pagination.PageModel;
import java.sql.Date;


/**
 * 接收记录定义模型；
 * @author liangshu
 */
public class RERecordQuery extends PageModel<RERecord> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//名称；
	private String receivemember;
	
	//状态；
	private String isdel;
	
	public String getIsDel() {
		return isdel;
	}

	public void setIsDel(String isdel) {
		this.isdel = isdel;
	}
	
	public String getReceivemember() {
		return receivemember;
	}

	public void setReceivemember(String receivemember) {
		this.receivemember = receivemember;
	}
	
} 
