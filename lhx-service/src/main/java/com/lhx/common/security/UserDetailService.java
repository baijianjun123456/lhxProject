package com.lhx.common.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.lhx.common.constants.MessageConstants;
import com.lhx.common.utils.ResourceMessageUtils;
import com.lhx.system.service.constants.SystemConstants;
import com.lhx.system.service.impl.UserManagerServiceImpl;
import com.lhx.system.user.model.User;


public class UserDetailService implements UserDetailsService {
	
	@Autowired
	private UserManagerServiceImpl userManagerServiceImpl;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User loginUser = userManagerServiceImpl.get(createCondition(username));
		
		if(loginUser == null){
			throw new UsernameNotFoundException(ResourceMessageUtils.getMessage(MessageConstants.LoginError.USER_NOT_FOUNT, null));
		}
		
		if(SystemConstants.DELETE_STATE.equals(loginUser.getStatus())){
			throw new AuthenticationServiceException(ResourceMessageUtils.getMessage(MessageConstants.DataStatus.DELETE_STATUS, new String[]{"用户"}));

		}else if(SystemConstants.STOP_STATE.equals(loginUser.getStatus())){
			throw new AuthenticationServiceException(ResourceMessageUtils.getMessage(MessageConstants.DataStatus.STOP_STATUS,  new String[]{"用户"}));
			
		}else if(SystemConstants.EXPIRED_STATE.equals(loginUser.getStatus())){
			throw new AuthenticationServiceException(ResourceMessageUtils.getMessage(MessageConstants.DataStatus.INVALID_STATUS, new String[]{"用户"}));
		}
		
		List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>();

		
		return new org.springframework.security.core.userdetails.User(loginUser.getAccounts(), loginUser.getPassword(),isEnabled(loginUser), true, true, true, dbAuths);
	}
	
	private static boolean isEnabled(User user_){
		boolean result = true;
		
		if(SystemConstants.STOP_STATE.equals(user_.getStatus())){
			result =  false;
		}
		return result;
		
	}
	
	/**
	 * 构建查询对象。
	 * @param username：用户名称
	 * @return 
	 */
	private static User createCondition(String username){
		User user = new User();
		user.setAccounts(username);
		return user;
	}

}
