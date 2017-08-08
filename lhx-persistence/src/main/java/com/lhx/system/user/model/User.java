package com.lhx.system.user.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.lhx.cache.utils.CacheUtil;
import com.lhx.common.mybatis.BaseModel;
import com.lhx.system.dict.model.Dict;
import com.lhx.utils.StringUtil;


/**
 * 用户定义模型；
 * @author liangshu
 */
public class User extends BaseModel implements Serializable {
	
	private static Map<String,String> userStatusMap = null;

	private static final long serialVersionUID = 1L;

	//机构ID
	private String orgId;

	//机构层级码
	private String orgLevel;

	//机构识别码
	private String orgIdenty;

	//机构识别码
	private String password;

	//密码
	private String accounts;

	//用户名全拼
	private String nameSpell;

	//性别（0：女，1：男）
	private String sex;

	//主题ID
	private String themId;

	//用户头像ID
	private String headImageId;

	//绑定IP
	private String bindId;

	//生效日期
	private String effectDate;

	//失效日期
	private String cancelDate;

	//座机电话
	private String phone;

	//移动电话
	private String mobile;

	//QQ
	private String qq;

	//微信
	private String wx;

	//邮箱
	private String email;

	//是否在线
	private String isOline;

	//排序
	private String orderBy;
	
	private String statusName;
	
	public static User newInstance(String id__,String orgId_,String orgLevel_,String orgIdenty_,String password_,String accounts_,String name_){
		User user = new User();
		user.setId_(id__);
		user.setOrgId(orgId_);
		user.setOrgLevel(orgLevel_);
		user.setOrgIdenty(orgIdenty_);
		user.setPassword(password_);
		user.setAccounts(accounts_);
		user.setName(name_);
		return user;
	}

	public String getOrgId(){
		return this.orgId;
	}
	public void setOrgId(String orgId_){
		this.orgId = orgId_;
	}
	public String getOrgLevel(){
		return this.orgLevel;
	}
	public void setOrgLevel(String orgLevel_){
		this.orgLevel = orgLevel_;
	}
	public String getOrgIdenty(){
		return this.orgIdenty;
	}
	public void setOrgIdenty(String orgIdenty_){
		this.orgIdenty = orgIdenty_;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password_){
		this.password = password_;
	}
	public String getAccounts(){
		return this.accounts;
	}
	public void setAccounts(String accounts_){
		this.accounts = accounts_;
	}
	public String getNameSpell(){
		return this.nameSpell;
	}
	public void setNameSpell(String nameSpell_){
		this.nameSpell = nameSpell_;
	}
	public String getSex(){
		return this.sex;
	}
	public void setSex(String sex_){
		this.sex = sex_;
	}
	public String getThemId(){
		return this.themId;
	}
	public void setThemId(String themId_){
		this.themId = themId_;
	}
	public String getHeadImageId(){
		return this.headImageId;
	}
	public void setHeadImageId(String headImageId_){
		this.headImageId = headImageId_;
	}
	public String getBindId(){
		return this.bindId;
	}
	public void setBindId(String bindId_){
		this.bindId = bindId_;
	}
	public String getEffectDate(){
		return this.effectDate;
	}
	public void setEffectDate(String effectDate_){
		this.effectDate = effectDate_;
	}
	public String getCancelDate(){
		return this.cancelDate;
	}
	public void setCancelDate(String cancelDate_){
		this.cancelDate = cancelDate_;
	}
	public String getPhone(){
		return this.phone;
	}
	public void setPhone(String phone_){
		this.phone = phone_;
	}
	public String getMobile(){
		return this.mobile;
	}
	public void setMobile(String mobile_){
		this.mobile = mobile_;
	}
	public String getQq(){
		return this.qq;
	}
	public void setQq(String qq_){
		this.qq = qq_;
	}
	public String getWx(){
		return this.wx;
	}
	public void setWx(String wx_){
		this.wx = wx_;
	}
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email_){
		this.email = email_;
	}
	public String getIsOline(){
		return this.isOline;
	}
	public void setIsOline(String isOline_){
		this.isOline = isOline_;
	}
	public String getOrderBy(){
		return this.orderBy;
	}
	public void setOrderBy(String orderBy_){
		this.orderBy = orderBy_;
	}
	
	public static Map<String, String> getUserStatusMap() {
		if(CollectionUtils.isEmpty(userStatusMap)){
			List<Dict> dictList = CacheUtil.getDictCache().search("USER_STATUS", "pcode", Dict.class);
			userStatusMap = new HashMap<String,String>();
			for(Dict dict : dictList){
				userStatusMap.put(dict.getValue(), dict.getName());
			}
		}
		return userStatusMap;
	}

	public static void setUserStatusMap(Map<String, String> userStatusMap) {
		User.userStatusMap = userStatusMap;
	}
	
	public String getStatusName() {
		
		return statusName;
	}

	@Override
	public void setStatus(String status) {
		
		super.setStatus(status);
		
		if(StringUtil.isNotBlank(status)){
			statusName =  getUserStatusMap().get(status);
		}
	}


} 
