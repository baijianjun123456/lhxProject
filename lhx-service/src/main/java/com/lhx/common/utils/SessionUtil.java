package com.lhx.common.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.lhx.system.role.model.Role;
import com.lhx.system.service.entity.UserLoginInfo;

public class SessionUtil {
	
	public static final String USER_LOGIN_INFO = "USER_INFO";
	
	public static boolean isLogin(HttpServletRequest request){
		
		Object userInfo = request.getSession().getAttribute(USER_LOGIN_INFO);
		
		return userInfo == null ? false : true;
	}
	
	public static UserLoginInfo getLoginUser(HttpServletRequest request){
		return (UserLoginInfo)(request.getSession().getAttribute(USER_LOGIN_INFO));
	}
	
	public static void addAttr(HttpServletRequest request,String attrKey,Object attrObj){
		addAttr(request.getSession(),attrKey,attrObj);
	}
	
	public static void addAttr(HttpSession session,String attrKey,Object attrObj){
		session.setAttribute(attrKey, attrObj);
	}
	
	public static void removeAttr(HttpServletRequest request,String attrKey){
		removeAttr(request.getSession(),attrKey);
	}
	
	public static void removeAttr(HttpSession session,String attrKey){
		session.removeAttribute(attrKey);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getAttr(HttpSession session,String attrKey,Class<T> type){
		Object attrObj = session.getAttribute(attrKey);
		return attrObj == null ? null : (T)attrObj ;

	}

	public static <T> T getAttr(HttpServletRequest request,String attrKey,Class<T> type){		
		return getAttr(request.getSession(),attrKey,type);	
	}
	
	public static void invalidate(HttpServletRequest request){
		request.getSession().invalidate();
	}
	
	public static void invalidate(HttpSession session){
		session.invalidate();
	}
	
	public static boolean isHaveRole(HttpServletRequest request,String roleID){
		boolean isHaveRole = false;
	
		UserLoginInfo logininfo = getLoginUser(request);
		

		
		if(logininfo == null){
			isHaveRole = false;
			return  isHaveRole;
		}
		
		if("system".equals(logininfo.getUser().getAccounts())){
			return true;
		}
		
		List<Role> roleList = logininfo.getRoleList();
		
		if(roleList == null){
			isHaveRole = false;
			return  isHaveRole;
		}
		
		for(int i = 0 ; i < roleList.size() ;i++){
			if(roleID.equals(roleList.get(i).getCode())){
				isHaveRole = true;
				break;
			}
		}
		return isHaveRole;
	}
	

}
