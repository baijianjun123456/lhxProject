package com.lhx.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author liangshu
 *
 */
public class DateUtil {
	
	private static final String  FORMATTING_STYLE_DATE = "yyyy-MM-dd";
	
	private static final String  FORMATTING_STYLE_TIME = "yyyy-MM-dd HH:mm:ss";
	
	
	/**
	 * 获取系统化当前日期（格式：yyyy-MM-dd）；
	 * @return
	 */
	public static String getSysCurrentTime(){
		return DateUtil.format(Calendar.getInstance().getTime(),FORMATTING_STYLE_TIME);
	}
	
	/**
	 * 获取系统化当前时间（格式：yyyy-MM-dd HH:mm:ss）；
	 * @return
	 */
	public static String getSysCurrentDate(){
		return DateUtil.format(Calendar.getInstance().getTime(),FORMATTING_STYLE_DATE);
	}
	
	/**
	 * 获取指定格式的系统当前时间;
	 * @param formatStyle : 日期格式模式；
	 * @return
	 */
	public static String getSysCurrentTime(String formatStyle){
		return DateUtil.format(Calendar.getInstance().getTime(),formatStyle);
	}
	
	/**
	 * 获取指定时间指定格式的时间串;
	 * @param date_ ：需格式化的日期对象；
	 * @param formartStyle_：日期格式模式；
	 * @return
	 */
	private static String format(Date date_,String formartStyle_){
		DateFormat formart = new SimpleDateFormat(formartStyle_);
		return  formart.format(date_);
	}
	
}
