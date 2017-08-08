package com.lhx.common.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.google.gson.Gson;
import com.lhx.common.constants.HttpStatus;
import com.lhx.common.utils.SessionUtil;
import com.lhx.system.service.entity.UserLoginInfo;
import com.lhx.system.service.UserManagerService;
import com.lhx.utils.RequestUtils;


public class LoginLogAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	@Autowired
	private UserManagerService  userManagerService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

		 UserLoginInfo userLoginInfo = userManagerService.initLoginUser(RequestUtils.getParamter(request, "userName"));
		 SessionUtil.addAttr(request, SessionUtil.USER_LOGIN_INFO, userLoginInfo);
		 setResponse(request, response);
	}
	
	public void setResponse(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Map<String, String> out = new HashMap<String, String>();
		out.put(HttpStatus.TGA_AJAX_RESCD, "00"); 
		out.put(HttpStatus.TGA_AJAX_RESURL, this.getDefaultTargetUrl()); 
		response.setHeader("Content-Type", "application/json;charset=UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.print(new Gson().toJson(out));
			writer.flush();
			writer.close();
		} catch (Exception e) {
			logger.error("respone with json  is failed!");
		}
	}


}
