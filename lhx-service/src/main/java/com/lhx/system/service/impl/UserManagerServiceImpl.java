package com.lhx.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lhx.system.service.constants.SystemConstants;
import com.lhx.system.service.entity.UserLoginInfo;
import com.lhx.system.org.dao.OrgDao;
import com.lhx.system.role.dao.RoleDao;
import com.lhx.system.service.UserManagerService;
import com.lhx.system.user.dao.UserDao;
import com.lhx.system.user.model.User;
import com.lhx.system.user.model.UserQuery;
import com.lhx.system.userRole.dao.UserRoleDao;

@Service
public class UserManagerServiceImpl implements UserManagerService {
	
    @Autowired
	private UserDao  userDao;

    @Autowired
	private RoleDao  roleDao;
    
    @Autowired
	private UserRoleDao  userRoleDao;
	
    @Autowired
	private OrgDao  orgDao;
	
	@Override
	public boolean addUser(User user_) {
		userDao.save(user_);
		return true;
	}

	@Override
	public boolean removeUser(User user_, boolean flag) {
		if(flag){
			userDao.delete(user_.getId_());
		}
		else{
			user_.setStatus(SystemConstants.DELETE_STATE);
			userDao.update(user_);
		}
		return true;
	}

	@Override
	public int updateUser(User user_) {
		
		return 0;
	}
	
	public User get(User user_){
		List<User> userList = userDao.queryList(user_);
		return (userList == null || userList.size() <= 0) ? null : userList.get(0);
	}
	
	public List<User> getList(User user_){
		return userDao.queryList(user_);
	}
	
	public List<User> getListPage(UserQuery userQuery){
		return userDao.queryListPage(userQuery);
	}
	
	/**
	 * 查询用户登录信息。
	 * @param accounts：登录账号说
	 * @return
	 */
	public UserLoginInfo  initLoginUser(String accounts){
		User qUser = new User();
		qUser.setAccounts(accounts);
		User user = userDao.queryList(qUser).get(0);
		
		//UserRole qUserRole = new UserRole();
		//qUserRole.setUserId(user.getId_());
		//ssList<UserRole> uesrRoleList = userRoleDao.queryList(qUserRole);
		
		UserLoginInfo userLoginInfo = UserLoginInfo.newInstance(user, null, null, null);
		
		return userLoginInfo;
		
	}

}
