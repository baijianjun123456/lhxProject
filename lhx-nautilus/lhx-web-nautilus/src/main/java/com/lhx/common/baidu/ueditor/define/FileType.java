package com.lhx.common.baidu.ueditor.define;

import java.util.HashMap;
import java.util.Map;
/**
 * 文件类型
 * @author bjj
 * 2017.0718
 *
 */
public class FileType {

	public static final String JPG = "JPG";
	
	private static final Map<String, String> types = new HashMap<String, String>(){{
		
		put( FileType.JPG, ".jpg" );
		
	}};
	
	public static String getSuffix ( String key ) {
		return FileType.types.get( key );
	}
	
	/**
	 * 根据给定的文件名获取文件
	 * @param filename
	 * @return
	 */
	public static String getSuffixByFilename ( String filename ) {
		
		return filename.substring( filename.lastIndexOf( "." ) ).toLowerCase();
		
	}
	
}
