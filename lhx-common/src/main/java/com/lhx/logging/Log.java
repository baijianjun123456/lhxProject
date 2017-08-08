package com.lhx.logging;

/**
 * 
 * @author liangshu
 * 日志接口；
 */
public interface Log {
	
	/**
	 * 检查DEBUG级别日志是否有权限输出；
	 * @return:true:有权限；false:无权限；
	 */
    public abstract boolean isDebugEnabled();
    
    /**
	 * 检查TRACE级别日志是否有权限输出；
	 * @return:true:有权限；false:无权限；
	 */
    public abstract boolean isTraceEnabled();
    
    /**
     * 输出错误日志；
     * @param errorInfo : 错误信息。
     * @param throwable ：异常堆栈信息
     */
    public abstract void error(Object errorInfo, Throwable throwable);
    
    /**
     * 输出错误日志；
     * @param errorInfo ：  错误信息。
     */
    public abstract void error(Object errorInfo);
    
    /**
     * 输出debug日志；
     * @param debugInfo : debug日志信息。
     */
    public abstract void debug(Object debugInfo);
    
    /**
     * 输出跟踪日志信息
     * @param traceInfo ： 跟踪日志信息。
     */
    public abstract void trace(Object traceInfo);
    
    /**
     * 输出警告日志。
     * @param warInfo ：警告日志信息。
     */
    public abstract void warn(Object warInfo);
}
