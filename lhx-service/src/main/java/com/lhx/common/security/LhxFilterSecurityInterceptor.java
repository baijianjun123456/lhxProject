package com.lhx.common.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.lhx.common.constants.HttpStatus;
import com.lhx.common.security.utils.TrustUrlListForNoSession;
import com.lhx.common.security.utils.TrustUrlListForValidSession;
import com.lhx.common.utils.SessionUtil;

public class LhxFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter{
	
	private String errorPage ;
	
	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	
	@Override
	public Class<?> getSecureObjectClass() {
		return  FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.getSecurityMetadataSource();
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		HttpServletResponse httpresponse = (HttpServletResponse)response;
		
		String contentPath = httpRequest.getContextPath();
		
		String reqUrl = httpRequest.getRequestURI().replaceFirst(contentPath, "");
		
		if(TrustUrlListForNoSession.isTrust(reqUrl)){
			chain.doFilter(request, response);
			return ;
		}
		
		if(TrustUrlListForValidSession.isTrust(reqUrl)){
			if(!SessionUtil.isLogin(httpRequest)){
				httpresponse.sendRedirect(contentPath);
			}
			chain.doFilter(request, response);
			return ;
		}
		
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		invoke(fi);
	}
	
	
	public void invoke(FilterInvocation fi) throws IOException,ServletException {
		InterceptorStatusToken token = null;
		try {
			token = super.beforeInvocation(fi);
		} catch (IllegalArgumentException e) {
			HttpServletRequest httpRequest = fi.getRequest();
			HttpServletResponse httpResponse = fi.getResponse();
			//String url = httpRequest.getRequestURI().replaceFirst(httpRequest.getContextPath(), "");
			httpResponse.setStatus(HttpStatus.SC_NOT_ACCEPTABLE);
		    RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(this.errorPage);
		    dispatcher.forward(httpRequest, httpResponse);
			return;
		}
		
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}


	@Override
	public void init(FilterConfig filterconfig) throws ServletException {

	}
	
	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return securityMetadataSource;
	}

	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}

	public String getErrorPage() {
		return errorPage;
	}

	public void setErrorPage(String errorPage) {
		this.errorPage = errorPage;
	}
	

}
