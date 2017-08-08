package com.lhx.logging.stdout;

import com.lhx.logging.Log;
import com.lhx.utils.JsonUtil;

/**
 * 系统输出日志
 * @author liangshu
 *
 */
public class StdOutLogImpl implements Log {
	
	public StdOutLogImpl(Class<?> busClass){
		
	}

	@Override
	public boolean isDebugEnabled() {
		return true;
	}

	@Override
	public boolean isTraceEnabled() {
		return true;
	}

	@Override
	public void error(Object errorInfo, Throwable throwable) {
		System.err.print(JsonUtil.objToStrFrm(errorInfo));
		throwable.printStackTrace();
	}

	@Override
	public void error(Object errorInfo) {
		System.err.print(JsonUtil.objToStrFrm(errorInfo));
	}

	@Override
	public void debug(Object debugInfo) {
		System.out.print(JsonUtil.objToStrFrm(debugInfo));
	}

	@Override
	public void trace(Object traceInfo) {
		System.out.print(JsonUtil.objToStrFrm(traceInfo));
	}

	@Override
	public void warn(Object warInfo) {
		System.out.print(JsonUtil.objToStrFrm(warInfo));
	}

}
