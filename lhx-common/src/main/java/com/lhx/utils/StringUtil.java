package com.lhx.utils;

/**
 * 
 * 字符串工具类。
 * @author liangshu
 *
 */
public class StringUtil {
	
	/**
	 * 校验目标字符串是否为NULL或""。
	 * @param descStr:被校验字符串。
	 * @return boolean : true,flase。
	 */
	public static boolean isBlank(String descStr){
		return descStr == null ||   "".equals(descStr);
	}
	
	public static boolean isNotBlank(String descStr){
		return !(isBlank(descStr));
	}
	
	/**
	 * 获取字符串为空则返回空字符串;
	 * @param descStr:被校验字符串。
	 * @return
	 */
	public static String getStr(String descStr){
		return descStr == null ? "" : descStr;
	}
	
	/**
	 * 将数据库字段名称转化为属性名；
	 * @param descStr:被校验字符串。
	 * @return
	 */
	public static String bdToProp(String descStr){
		StringBuffer fileNameBF = new StringBuffer();
		descStr = descStr.toLowerCase();
		if(descStr.indexOf("_") != -1 && descStr.split("_").length > 1){
			String[] split_strs = descStr.split("_");
			for(int i = 0; i < split_strs.length; i++){
				if(i == 0){
					fileNameBF.append(split_strs[i]);
				}
				else{
					fileNameBF.append(upperFirst(split_strs[i]));
				}
			}
			descStr = fileNameBF.toString();
		}
		return descStr;
	}
	
	public static String upperFirst(String descStr){
		return descStr.substring(0, 1).toUpperCase() + descStr.substring(1, descStr.length());	}
	
	public static String lowerFirst(String descStr){
		return descStr.substring(0, 1).toLowerCase()+descStr.substring(1,descStr.length());
	}
	
	
}
