package com.lhx.common.baidu.ueditor.define;

/**
 * 操作类型
 * @author bjj
 * 2017.0718
 *
 */
public interface State {
	
	public boolean isSuccess ();
	
	public void putInfo( String name, String val );
	
	public void putInfo ( String name, long val );
	
	public String toJSONString ();

}
