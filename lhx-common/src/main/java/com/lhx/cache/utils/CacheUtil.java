package com.lhx.cache.utils;


import com.lhx.cache.CacheManager;
import com.lhx.utils.SpringConfigTool;

public class CacheUtil{
	
	public static  CacheManager getDictCache(){
		return CacheUtil.getCacheManager("DictData");
	}
	
	private static CacheManager getCacheManager(String cacheName){
		CacheManager cacheManager = SpringConfigTool.getBean("busCacheManager",CacheManager.class);
		cacheManager.setCacheName(cacheName);
		return cacheManager;
	}

}
	