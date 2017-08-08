package com.lhx.utils;

import com.google.gson.Gson;
import java.lang.reflect.Type;

/**
 * 字符串-对象转换工具类
 * @author liangshu
 *
 */
public class JsonUtil {
	
	/**
	 * 将对象转换成字符串；
	 * @param descObj
	 * @return
	 */
	public static String objToStr(Object descObj){
		Gson gson = new Gson();
        return gson.toJson(descObj);
	}
	
	/**
	 * 将对象转换成带格式化的字符串；
	 * @param descObj
	 * @return
	 */
	public static String objToStrFrm(Object descObj){
		Gson gson = new Gson();
        return FormatUtil.formatJson(descObj.getClass().getName()+"="+gson.toJson(descObj));
	}
	
	public static <T>T strToObj(String descStr,Type type){
		Gson gson = new Gson();
		return gson.fromJson(descStr, type);
	}

}
