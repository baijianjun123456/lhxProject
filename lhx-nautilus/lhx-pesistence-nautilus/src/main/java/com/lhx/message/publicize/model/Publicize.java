package com.lhx.message.publicize.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;



/**
 * 发布公告表定义模型；
 * @author liangshu
 */
public class Publicize extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//
	private String title;

	//
	private String abstrac;

	//
	private String content;

	//
	private String member;

	//
	private String isdel;

	//
	private String thcontent;

	//
	private String level;

	//
	private String attchid;

	//
	private String imageid;

	//
	private String String;

	//
	//private String status;

	//
	private String remark;

	public static Publicize newInstance(String id__,String title,String abstrac,String content,String member,String isdel,String thcontent,String level,String attchid,String imageid,String String,String status,String remark){
		Publicize publicize = new Publicize();
		publicize.setId_(id__);
		publicize.setTitle(title);
		publicize.setAbstrac(abstrac);
		publicize.setContent(content);
		publicize.setMember(member);
		publicize.setIsdel(isdel);
		publicize.setThcontent(thcontent);
		publicize.setLevel(level);
		publicize.setAttchid(attchid);
		publicize.setImageid(imageid);
		publicize.setFabutime(String);
		publicize.setStatus(status);
		publicize.setRemark(remark);
		return publicize;
	}

	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title_){
		this.title = title_;
	}
	public String getAbstrac(){
		return this.abstrac;
	}
	public void setAbstrac(String abstrac_){
		this.abstrac = abstrac_;
	}
	public String getContent(){
		return this.content;
	}
	public void setContent(String content_){
		this.content = content_;
	}
	public String getMember(){
		return this.member;
	}
	public void setMember(String member_){
		this.member = member_;
	}
	public String getIsdel(){
		return this.isdel;
	}
	public void setIsdel(String isdel_){
		this.isdel = isdel_;
	}
	public String getThcontent(){
		return this.thcontent;
	}
	public void setThcontent(String thcontent_){
		this.thcontent = thcontent_;
	}
	public String getLevel(){
		return this.level;
	}
	public void setLevel(String level_){
		this.level = level_;
	}
	public String getAttchid(){
		return this.attchid;
	}
	public void setAttchid(String attchid_){
		this.attchid = attchid_;
	}
	public String getImageid(){
		return this.imageid;
	}
	public void setImageid(String imageid_){
		this.imageid = imageid_;
	}
	public String getFabutime(){
		return this.String;
	}
	public void setFabutime(String fabutime_){
		this.String = fabutime_;
	}
/*	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status_){
		this.status = status_;
	}*/
	public String getRemark(){
		return this.remark;
	}
	public void setRemark(String remark_){
		this.remark = remark_;
	}

} 
