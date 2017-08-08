package com.lhx.logging.log4j;

import org.apache.log4j.Logger;

import com.lhx.logging.Log;
import com.lhx.utils.JsonUtil;

/**
 * log4j日志输出类；
 * @author liangshu
 *
 */
public class Log4jLogImpl implements Log {
	
	private Logger log;
	
	public Log4jLogImpl(Class<?> busClass){
		log = Logger.getLogger(busClass);
	}

	@Override
	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	@Override
	public boolean isTraceEnabled() {
		return log.isTraceEnabled();
	}

	@Override
	public void error(Object errorInfo, Throwable throwable) {
		log.error(JsonUtil.objToStrFrm(errorInfo), throwable);
	}

	@Override
	public void error(Object errorInfo) {
		log.error(JsonUtil.objToStrFrm(errorInfo));
	}

	@Override
	public void debug(Object debugInfo) {
		log.debug(JsonUtil.objToStrFrm(debugInfo));
	}

	@Override
	public void trace(Object traceInfo) {
		log.trace(JsonUtil.objToStrFrm(traceInfo));
	}

	@Override
	public void warn(Object warInfo) {
		log.warn(JsonUtil.objToStrFrm(warInfo));
	}

}
