package com.lhx.logging.exception;

/**
 * 构建日志异常类；
 * @author liangshu
 *
 */
public class LogException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public LogException(){
		
	}
	
	public LogException(String message) {
        super(message);
    }
	
	public LogException(Throwable cause) {
        super(cause);
    }
	
	public LogException(String message, Throwable cause) {
        super(message, cause);
    }
	
}
