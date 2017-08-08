package com.lhx.message.receiverecord.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;



/**
 * 接收记录定义模型；
 * @author liangshu
 */
public class RERecord extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//
	private String deptid;

	//
	private String roleid;

	//
	private String level;

	//
	private String receivemember;

	//
	private String receivetime;

	//
	private String pubid;

	//
	private String pubtitle;

	//
	private String isdel;

	//
	private String isshow;

	//
	private String remark;

	public static RERecord newInstance(String id__,String deptid_,String roleid_,String level_,String receivemember_,String receivetime_,String pubid_,String pubtitle_,String isdel_,String isshow_,String remark_){
		RERecord rErecord = new RERecord();
		rErecord.setId_(id__);
		rErecord.setDeptid(deptid_);
		rErecord.setRoleid(roleid_);
		rErecord.setLevel(level_);
		rErecord.setReceivemember(receivemember_);
		rErecord.setReceivetime(receivetime_);
		rErecord.setPubid(pubid_);
		rErecord.setPubtitle(pubtitle_);
		rErecord.setIsdel(isdel_);
		rErecord.setIsshow(isshow_);
		rErecord.setRemark(remark_);
		return rErecord;
	}

	public String getDeptid(){
		return this.deptid;
	}
	public void setDeptid(String deptid_){
		this.deptid = deptid_;
	}
	public String getRoleid(){
		return this.roleid;
	}
	public void setRoleid(String roleid_){
		this.roleid = roleid_;
	}
	public String getLevel(){
		return this.level;
	}
	public void setLevel(String level_){
		this.level = level_;
	}
	public String getReceivemember(){
		return this.receivemember;
	}
	public void setReceivemember(String receivemember_){
		this.receivemember = receivemember_;
	}
	public String getReceivetime(){
		return this.receivetime;
	}
	public void setReceivetime(String receivetime_){
		this.receivetime = receivetime_;
	}
	public String getPubid(){
		return this.pubid;
	}
	public void setPubid(String pubid_){
		this.pubid = pubid_;
	}
	public String getPubtitle(){
		return this.pubtitle;
	}
	public void setPubtitle(String pubtitle_){
		this.pubtitle = pubtitle_;
	}
	public String getIsdel(){
		return this.isdel;
	}
	public void setIsdel(String isdel_){
		this.isdel = isdel_;
	}
	public String getIsshow(){
		return this.isshow;
	}
	public void setIsshow(String isshow_){
		this.isshow = isshow_;
	}
	public String getRemark(){
		return this.remark;
	}
	public void setRemark(String remark_){
		this.remark = remark_;
	}

} 
