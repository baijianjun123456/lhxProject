package com.lhx.logging;

import java.lang.reflect.Constructor;

import com.lhx.logging.exception.LogException;
import com.lhx.logging.jdk.JdkLogImpl;
import com.lhx.logging.log4j.Log4jLogImpl;
import com.lhx.logging.log4j2.Log4j2LogImpl;
import com.lhx.logging.nologging.NoLogImpl;
import com.lhx.logging.slf4j.Slf4jLogImpl;
import com.lhx.logging.stdout.StdOutLogImpl;

/**
 * 日志工厂类
 * @author liangshu
 *
 */
public class LogFactory {
	
	private static Constructor<?> logConstructor = null;
	
	public static Log getLogger(Class<?> busClass){
		try {
			return (Log)logConstructor.newInstance(new Object[] { busClass });
		} catch (Throwable ex) {
			throw new LogException(new StringBuilder().append("创建 ").append(busClass.getName()).append(" 日志失败，失败原因：").toString(),ex);
		}
	}
	
	private static void useJdkLog(){
		setImplement(JdkLogImpl.class);
	}
	
	private static void useLog4Log(){
		setImplement(Log4jLogImpl.class);
	}
	
	private static void useLog4j2Log(){
		setImplement(Log4j2LogImpl.class);
	}
	
	private static void useSlf4jLogImpl(){
		setImplement(Slf4jLogImpl.class);
	}
	
	private static void useNoLog(){
		setImplement(NoLogImpl.class);
	}
	
	private static void useStdOutLog(){
		setImplement(StdOutLogImpl.class);
	}
	
	private static void setImplement(Class<?> logImpClass){
		try {
			logConstructor = logImpClass.getConstructor(new Class[]{Class.class});
		} catch (Throwable ex) {
			throw new LogException(new StringBuilder().append("创建 ").append(logImpClass).append(" 日志失败，失败原因：").toString(),ex);
		} 
	}
	
	public  static void tryImplement(Runnable runnable){
		if(logConstructor == null){
			try {
				runnable.run();
			} catch (Throwable ex) {

			}
		}
	}
	
	static{
		tryImplement(new Runnable(){
			@Override
			public void run() {
				useSlf4jLogImpl();
			}
		});
		tryImplement(new Runnable(){
			@Override
			public void run() {
				useLog4j2Log();
			}
		});
		
		tryImplement(new Runnable(){
			@Override
			public void run() {
				useLog4Log();
			}
		});
		
		tryImplement(new Runnable(){
			@Override
			public void run() {
				useStdOutLog();
			}
		});
		
		tryImplement(new Runnable(){
			@Override
			public void run() {
				useJdkLog();
			}
		});
		
		tryImplement(new Runnable(){
			@Override
			public void run() {
				useNoLog();
			}
		});		

			
	}

}
