package com.lhx.common.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.google.gson.Gson;
import com.lhx.common.constants.HttpStatus;
import com.lhx.common.utils.ResourceMessageUtils;
import com.lhx.utils.StringUtil;

public class LoginAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	private String defaultFailureUrl ;

	private Map<String, String> exceptionMappings = new HashMap<String, String>();
	
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		
		String errMsg="";
		String errCode = exceptionMappings.get(exception.getClass().getName());
		
		if(StringUtil.isNotBlank(errCode)){
			errMsg = ResourceMessageUtils.getMessage(errCode, null);
		}else{
			errMsg=exception.getMessage();
		}

		setResponse(request, response,errMsg);

	}
	
	public void setResponse(HttpServletRequest request, HttpServletResponse response,String errMsg)
			throws IOException {
		Map<String, String> out = new HashMap<String, String>();
		out.put(HttpStatus.TGA_AJAX_RESCD, "01"); 
		out.put(HttpStatus.TGA_AJAX_RESMSG, "登录失败: "+errMsg); 
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

	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}

	public Map<String, String> getExceptionMappings() {
		return exceptionMappings;
	}

	public void setExceptionMappings(Map<String, String> exceptionMappings) {
		this.exceptionMappings = exceptionMappings;
	}

	
}
