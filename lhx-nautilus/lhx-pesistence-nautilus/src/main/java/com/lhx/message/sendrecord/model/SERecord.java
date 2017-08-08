package com.lhx.message.sendrecord.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;



/**
 * 发送记录定义模型；
 * @author liangshu
 */
public class SERecord extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//
	private String deptid;

	//
	private String roleid;

	//
	private String level;

	//
	private String sendmember;

	//
	private String sendtime;

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

	public static SERecord newInstance(String id__,String deptid_,String roleid_,String level_,String seceivemember_,String seceivetime_,String pubid_,String pubtitle_,String isdel_,String isshow_,String remark_){
		SERecord sERecord = new SERecord();
		sERecord.setId_(id__);
		sERecord.setDeptid(deptid_);
		sERecord.setRoleid(roleid_);
		sERecord.setLevel(level_);
		sERecord.setSendmember(seceivemember_);
		sERecord.setSendtime(seceivetime_);
		sERecord.setPubid(pubid_);
		sERecord.setPubtitle(pubtitle_);
		sERecord.setIsdel(isdel_);
		sERecord.setIsshow(isshow_);
		sERecord.setRemark(remark_);
		return sERecord;
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
	public String getSendmember(){
		return this.sendmember;
	}
	public void setSendmember(String sendmember_){
		this.sendmember = sendmember_;
	}
	public String getSendtime(){
		return this.sendtime;
	}
	public void setSendtime(String sendtime_){
		this.sendtime = sendtime_;
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
