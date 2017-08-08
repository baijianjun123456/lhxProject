package com.lhx.common.constants;

/**
 * 国际化常量表
 * @author liangshu
 *
 */
public class MessageConstants {
	
	
	//登录失败错误码
	public final class LoginError{
		
		//用户不存在
		public static final String USER_NOT_FOUNT = "login_errorcode_001";
		
		//密码错误
		public static final String LOGIN_PASSWORD_ERROR = "login_errorcode_002";
		
		//用户不可用
		public static final String USER_CANNOT_USER = "login_errorcode_003";
		
		//验证码错误
		public static final String LOGIN_ERROR_CODE = "login_errorcode_004";
		
		//其它错误
		public static final String LOGIN_OTHER_ERROR = "login_errorcode_005";
	}
	
	//数据状态；
	public final class DataStatus{
		
    	//删除
    	public static final String DELETE_STATUS= "delete_status_0" ;
    	
       	//正常
    	public static final String NORMAL_STATUS= "normal_status_1" ;
    	
       	//停用
    	public static final String STOP_STATUS= "stop_status_2" ;
    	
       	//失效/过期
    	public static final String INVALID_STATUS= "invalid_status_3" ;
		
		
	}


}
