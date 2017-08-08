package com.lhx.logging.jdk;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.lhx.logging.Log;
import com.lhx.utils.JsonUtil;

/**
 * JDK日志输出类；
 * @author liangshu
 *
 */
public class JdkLogImpl implements Log {
	
	private Logger log; 
	
	public JdkLogImpl(Class<?> busClass){
		log = Logger.getLogger(busClass.getName());
	}

	@Override 
	public boolean isDebugEnabled() {
		
		return log.isLoggable(Level.FINE);
	}

	@Override
	public boolean isTraceEnabled() {
		return log.isLoggable(Level.FINER);
	}

	@Override
	public void error(Object errorInfo, Throwable throwable) {
		log.log(Level.SEVERE, JsonUtil.objToStrFrm(errorInfo), throwable);
	}

	@Override
	public void error(Object errorInfo) {
		log.log(Level.SEVERE, JsonUtil.objToStrFrm(errorInfo));
	}

	@Override
	public void debug(Object debugInfo) {
		log.log(Level.FINE, JsonUtil.objToStrFrm(debugInfo));
	}

	@Override
	public void trace(Object traceInfo) {
		log.log(Level.FINER, JsonUtil.objToStrFrm(traceInfo));
	}

	@Override
	public void warn(Object warInfo) {
		log.log(Level.WARNING, JsonUtil.objToStrFrm(warInfo));
	}

}
