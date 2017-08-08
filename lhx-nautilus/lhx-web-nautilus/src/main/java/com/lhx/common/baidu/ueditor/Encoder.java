package com.lhx.common.baidu.ueditor;
/**
 * 编码处理
 * @author bjj
 * 2017.0718
 *
 */
public class Encoder {

	public static String toUnicode ( String input ) {
		
		StringBuilder builder = new StringBuilder();
		char[] chars = input.toCharArray();
		
		for ( char ch : chars ) {
			
			if ( ch < 256 ) {
				builder.append( ch );
			} else {
				builder.append( "\\u" +  Integer.toHexString( ch& 0xffff ) );
			}
			
		}
		
		return builder.toString();
		
	}
	
}