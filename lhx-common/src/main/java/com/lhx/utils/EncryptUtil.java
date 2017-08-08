package com.lhx.utils;

import com.lhx.security.MessageSecret;

/**
 * 加密工具
 * @author liangshu
 *
 */
public class EncryptUtil {
	
	private static MessageSecret messageSecret = null;
	
	static{
		try {
			messageSecret = (MessageSecret) Class.forName("com.lhx.security.impl.MD5MessageSecret").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
		} 
	}
	
	/**
	 * MD5加密方法。
	 * @param srcMessage ：加密源字符串。
	 * @return ：返回加密后的字符串。
	 */
	public static String md5encrypt(String srcMessage){
		if(messageSecret != null){
			return messageSecret.encode(srcMessage);
		}
		else{
			return srcMessage;
		}
	}
}
