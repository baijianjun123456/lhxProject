package com.lhx.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * SPRING容器上下文工具类。
 * @author liangshu
 *
 */
public class ApplicationContextUtil {
	
	static final Logger logger = LoggerFactory.getLogger(ApplicationContextUtil.class);

	
	private static AnnotationConfigWebApplicationContext context;
	

	public static void contextInitialized(Class<?> loadClass)
	{
		if (ApplicationContextUtil.context == null) {
			context = new AnnotationConfigWebApplicationContext();
			context.register(new Class[] { loadClass });
			context.refresh();
        } 
		
		logger.debug("Web application fully configured");
	} 
	
	public static AnnotationConfigWebApplicationContext getContext(){
		if(ApplicationContextUtil.context != null){
			return ApplicationContextUtil.context;
		}
		logger.error("spring尚容器未初始化！");
		return null;
	}
}
