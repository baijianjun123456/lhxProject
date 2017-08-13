package com.lhx.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Properties文件读取工具类
 * @author liangshu
 *
 */
public class PropertiesUtils {
	
	private static final Logger log = LoggerFactory.getLogger(PropertiesUtils.class);
	
	private static final Map<String,String> propMap = new HashMap<>();
	
	public static final String getProperties(String key_){
		return propMap.get(key_);
	}
	
	public static void load(String propFile){
		URL url = PropertiesUtils.class.getClassLoader().getResource(propFile);
		Properties prop = new Properties();
		try {
			prop.load(url.openStream());
			Set<Entry<Object,Object>> propSet = prop.entrySet();
			for(Entry<Object,Object> enry : propSet){
				propMap.put(enry.getKey().toString(), enry.getValue().toString());
			}
		} catch (IOException e) {
			log.error("Failed to read "+propFile+" file ");
		}
	}
	
	public static void load(String propFile,ClassLoader classLoader){
		URL url = classLoader.getResource(propFile);
		Properties prop = new Properties();
		try {
			prop.load(url.openStream());
			Set<Entry<Object,Object>> propSet = prop.entrySet();
			for(Entry<Object,Object> enry : propSet){
				propMap.put(enry.getKey().toString(), enry.getValue().toString());
			}
		} catch (IOException e) {
			log.error("Failed to read "+propFile+" file ");
		}
	}
	
	public static void loadProperties(InputStream in){
		Properties prop = new Properties();
		try {
			prop.load(in);
			Set<Entry<Object,Object>> propSet = prop.entrySet();
			for(Entry<Object,Object> enry : propSet){
				propMap.put(enry.getKey().toString(), enry.getValue().toString());
			}
		} catch (IOException e) {
			log.error("Faile："+in);
		}
	}

}
