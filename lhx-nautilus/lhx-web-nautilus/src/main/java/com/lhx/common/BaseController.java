package com.lhx.common;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
	
	/**
	 * 将请求参数放入response返回对象中；
	 * @param request
	 * @param responseMap
	 */
	public void setParameter(HttpServletRequest request,Map<String,Object>  responseMap){
		Enumeration<String> parameterNames = request.getParameterNames();
		
		while(parameterNames.hasMoreElements()){
			String parameterName = parameterNames.nextElement();
			responseMap.put(parameterName, request.getParameter(parameterName));
		}
	
	}

}
