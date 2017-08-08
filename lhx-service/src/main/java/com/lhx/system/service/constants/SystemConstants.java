package com.lhx.system.service.constants;

/**
 * 系统管理相关常量；
 * @author liangshu
 *
 */
public class SystemConstants {
	
	//删除状态；
	public static final String DELETE_STATE = "0";
	
	//停用状态；
	public static final String STOP_STATE = "2";
	
	//正常状态；
	public static final String NORMAL_STATE = "1";
	
	//过期/失效状态
    public static final String EXPIRED_STATE = "3";
    
    public final class Session{
    	
    	public static final String LOGIN_CODE = "LOGIN_CODE";
    	
    }
    
    public final class Status{
    	
    	//删除
    	public static final String DELETE= "0" ;
    	
       	//正常
    	public static final String NORMAL= "1" ;
    	
       	//停用
    	public static final String STOP= "2" ;
    	
       	//失效/过期
    	public static final String INVALID= "3" ;
    }

}
