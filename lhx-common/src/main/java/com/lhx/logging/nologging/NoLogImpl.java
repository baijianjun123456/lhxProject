package com.lhx.logging.nologging;

import com.lhx.logging.Log;

/**
 * 无日志输出类；
 * @author liangshu
 *
 */
public class NoLogImpl implements Log {
	
	public NoLogImpl(Class<?> busClass){
		
	}

	@Override
	public boolean isDebugEnabled() {
		return false;
	}

	@Override
	public boolean isTraceEnabled() {
		return false;
	}

	@Override
	public void error(Object errorInfo, Throwable throwable) {
	}

	@Override
	public void error(Object errorInfo) {

	}

	@Override
	public void debug(Object debugInfo) {

	}

	@Override
	public void trace(Object traceInfo) {

	}

	@Override
	public void warn(Object warInfo) {

	}

}
