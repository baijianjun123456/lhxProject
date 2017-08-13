package com.lhx.base;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import com.lhx.utils.ApplicationContextUtil;

@Configuration
@ImportResource({"classpath:resource/xml/spring/spring-persistence.xml"})
public class BaseTest {
	
	static{
		ApplicationContextUtil.contextInitialized(BaseTest.class);
	}
}
