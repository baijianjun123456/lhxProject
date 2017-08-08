package com.lhx.message.sendrecord.model;

import java.io.Serializable;
import com.lhx.common.mybatis.pagination.PageModel;
import java.sql.Date;


/**
 * 发送记录定义模型；
 * @author liangshu
 */
public class SERecordQuery extends PageModel<SERecord> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//发送人；
	private String seceivemember;
		
	//是否删除；
	private String isdel;
	
	public String getIsDel() {
		return isdel;
	}
	public void setIsDel(String isdel) {
		this.isdel = isdel;
	}
	
	public String getSeceivemember() {
		return seceivemember;
	}
	public void setSeceivemember(String seceivemember) {
		this.seceivemember = seceivemember;
	}
	
} 
