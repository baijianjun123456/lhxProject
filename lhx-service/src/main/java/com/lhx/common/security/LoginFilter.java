package com.lhx.common.security;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lhx.common.constants.MessageConstants;
import com.lhx.common.utils.ResourceMessageUtils;
import com.lhx.common.utils.SessionUtil;
import com.lhx.system.service.constants.SystemConstants;
import com.lhx.utils.EncryptUtil;
import com.lhx.utils.RequestUtils;
import com.lhx.utils.StringUtil;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {
	
	//是否验证验证码
	private boolean checkCode = true;

	public boolean isCheckCode() {
		return checkCode;
	}

	public void setCheckCode(boolean checkCode) {
		this.checkCode = checkCode;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		
		String userName = RequestUtils.getParamter(request, "userName");
		
		String password = RequestUtils.getParamter(request, "password");
		
		String userCode = RequestUtils.getParamter(request, "userCode");
		
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userName, EncryptUtil.md5encrypt(password));
		
		if(this.checkCode){
			if (StringUtil.isBlank(userCode) ||  !userCode.equalsIgnoreCase(SessionUtil.getAttr(request, SystemConstants.Session.LOGIN_CODE,String.class))) {
				throw new AuthenticationServiceException(ResourceMessageUtils.getMessage(MessageConstants.LoginError.LOGIN_ERROR_CODE, null));
			}
		}

		
		return this.getAuthenticationManager().authenticate(authRequest);
	}
	
	public static void main(String[] args){
		
		Date queueDate = new Date(5 * 60 * 1000);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(queueDate));
	}

}
