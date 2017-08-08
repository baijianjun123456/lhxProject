package com.lhx.message.uploadsetting.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;


/**
 * 上传设置表定义模型；
 * @author liangshu
 */
public class UPloadsetting extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//
	private String ipaddress;

	//
	private String status;

	//
	private String loginname;

	//
	private String password;

	//
	private String port;

	//
	private String isdel;

	//
	private String createtime;

	//
	private String sertype;

	//
	private String remark;

	public static UPloadsetting newInstance(String id__,String ipaddress__,String status__,String isdel__,String loginname__,String password__,String port__,String createtime__,String sertype__,String remark__){
		UPloadsetting uPloadsetting = new UPloadsetting();
		uPloadsetting.setId_(id__);
		uPloadsetting.setStatus(status__);
		uPloadsetting.setIsdel(isdel__);
		uPloadsetting.setIpaddress(ipaddress__);
		uPloadsetting.setLoginname(loginname__);
		uPloadsetting.setPassword(password__);
		uPloadsetting.setPort(port__);
		uPloadsetting.setCreatetime(createtime__);
		uPloadsetting.setSertype(sertype__);
		uPloadsetting.setRemark(remark__);
		return uPloadsetting;
	}

	public String getIpaddress(){
		return this.ipaddress;
	}
	public void setIpaddress(String ipaddress_){
		this.ipaddress = ipaddress_;
	}
	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status_){
		this.status = status_;
	}
	public String getLoginname(){
		return this.loginname;
	}
	public void setLoginname(String loginname_){
		this.loginname = loginname_;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password_){
		this.password = password_;
	}
	public String getPort(){
		return this.port;
	}
	public void setPort(String port_){
		this.port = port_;
	}
	public String getIsdel(){
		return this.isdel;
	}
	public void setIsdel(String isdel_){
		this.isdel = isdel_;
	}
	public String getCreatetime(){
		return this.createtime;
	}
	public void setCreatetime(String createtime_){
		this.createtime = createtime_;
	}
	public String getSertype(){
		return this.sertype;
	}
	public void setSertype(String sertype_){
		this.sertype = sertype_;
	}
	public String getRemark(){
		return this.remark;
	}
	public void setRemark(String remark_){
		this.remark = remark_;
	}

} 
