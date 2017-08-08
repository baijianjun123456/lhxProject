package com.lhx.system.service;

import java.util.List;

import com.lhx.system.service.entity.UserLoginInfo;
import com.lhx.system.user.model.User;
import com.lhx.system.user.model.UserQuery;

/**
 * 用户管理相关服务接口
 * @author liangshu
 *
 */
public interface UserManagerService {
	
	/**
	 * 添加新用户；
	 * @param user：新增用户目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addUser(User user_);
	
	/**
	 * 删除用户；
	 * @param user_:删除目标用户对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removeUser(User user_,boolean flag);
	
	/**
	 * 更新用户信息；
	 * @param user_：更新目标用户对象信息；
	 * @return : 被更新用户的总条数
	 */ 
	public  int  updateUser(User user_);
	
	
	/**
	 * 查询用户登录信息。
	 * @param accounts：登录账号说
	 * @return
	 */
	public UserLoginInfo  initLoginUser(String accounts);
	
	/**
	 * 查询用户列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<User> getListPage(UserQuery userQuery);
}
