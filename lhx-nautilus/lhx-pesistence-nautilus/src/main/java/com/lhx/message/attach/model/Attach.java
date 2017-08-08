package com.lhx.message.attach.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;



/**
 * 附件表定义模型；
 * @author liangshu
 */
public class Attach extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//
	private String name;

	//
	private String path;

	//
	private String type;

	//
	private String length;

	//
	private String member;

	//
	private String createtime;

	//
	private String isdel;

	//
	private String remark;

	public static Attach newInstance(String id__,String name_,String type_,String path_,String length_,String member_,String createtime_,String isdel_,String remark_){
		Attach attach = new Attach();
		attach.setId_(id__);
		attach.setName(name_);
		attach.setType(type_);
		attach.setPath(path_);
		attach.setLength(length_);
		attach.setMember(member_);
		attach.setCreatetime(createtime_);
		attach.setIsdel(isdel_);
		attach.setRemark(remark_);
		return attach;
	}

	public String getName(){
		return this.name;
	}
	public void setName(String name_){
		this.name = name_;
	}
	public String getPath(){
		return this.path;
	}
	public void setPath(String path_){
		this.path = path_;
	}
	public String getType(){
		return this.type;
	}
	public void setType(String type_){
		this.type = type_;
	}
	public String getLength(){
		return this.length;
	}
	public void setLength(String length_){
		this.length = length_;
	}
	public String getMember(){
		return this.member;
	}
	public void setMember(String member_){
		this.member = member_;
	}
	public String getCreatetime(){
		return this.createtime;
	}
	public void setCreatetime(String createtime_){
		this.createtime = createtime_;
	}
	public String getIsdel(){
		return this.isdel;
	}
	public void setIsdel(String isdel_){
		this.isdel = isdel_;
	}
	public String getRemark(){
		return this.remark;
	}
	public void setRemark(String remark_){
		this.remark = remark_;
	}

} 
