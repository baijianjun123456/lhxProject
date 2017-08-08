package com.lhx.security;

/**
 * 信息加密，解密接口。
 * @author liangshu
 *
 */
public interface MessageSecret {
	
	/**
	 * 加密。
	 * @param srcMessage ：源加密字符串。
	 * @return string : 加密后目标字符串。
	 */
	public String encode(String srcMessage);
	
	/**
	 * 解密
	 * @param srcMessage ：源解密字符串。
	 * @return String : 解密后目标字符串。
	 */
	public String decode(String srcMessage);

}
