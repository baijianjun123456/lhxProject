package com.lhx.common.utils;

import java.util.Locale;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * 获取国际化语言工具类；ࣻ
 * @author liangshu
 *
 */
public class ResourceMessageUtils implements InitializingBean{
	
	private  ResourceBundleMessageSource messageSource;
	
	private static ResourceMessageUtils self;
	
	public static String getMessage(String code,Object[] args){
		if(self == null){
			return "";
		}
		else{
			return self.getMessageSource().getMessage(code, args, Locale.getDefault());
		}
	}
	
	public ResourceBundleMessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		self = this;
	}

}
