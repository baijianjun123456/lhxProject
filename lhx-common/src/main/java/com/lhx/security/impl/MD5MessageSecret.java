package com.lhx.security.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import com.lhx.security.MessageSecret;
import com.lhx.security.codec.UTF8;

/**
 * md5加密
 * @author liangshu
 *
 */
public class MD5MessageSecret implements MessageSecret{
	
	/**
	 * 加密。
	 * @param srcMessage ：源加密字符串。
	 * @return string : 加密后目标字符串。
	 */
	@Override
	public String encode(String srcMessage) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			byte[] digest = messageDigest.digest(UTF8.encode(srcMessage));
			//return new BASE64Encoder().encodeBuffer(digest); 
			return new HexBinaryAdapter().marshal(digest);
		} catch (NoSuchAlgorithmException ex) {
			throw new IllegalArgumentException("No such Algorithm MD5",ex);
		}
	}
	
	/**
	 * 解密
	 * @param srcMessage ：源解密字符串。
	 * @return String : 解密后目标字符串。
	 */
	@Override
	public String decode(String srcMessage) {
		return srcMessage;
	}

}
