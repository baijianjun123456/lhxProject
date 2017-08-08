package com.lhx.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
	
	public static String getParamter(HttpServletRequest request,String paramkey){
		return request.getParameter(paramkey);
		
	}

}
