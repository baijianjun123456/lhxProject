package com.lhx.common.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import com.lhx.common.utils.SessionUtil;
import com.lhx.utils.StringUtil;

public class LhxAccessDeniedHandler extends AccessDeniedHandlerImpl implements AccessDeniedHandler {
	
	private String errorPage = "";
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,AccessDeniedException exception) throws IOException, ServletException {
		
		if(SessionUtil.isLogin(request)){
			
		}
		else{
			if(StringUtil.isBlank(errorPage)){
				 RequestDispatcher dispatcher = request.getRequestDispatcher(errorPage);
				 dispatcher.forward(request, response);
			}
			else{
				response.sendError(403, exception.getMessage());
			}
		}
	}
	
	public String getErrorPage() {
		return errorPage;
	}

	public void setErrorPage(String errorPage) {
		this.errorPage = errorPage;
	}

}
