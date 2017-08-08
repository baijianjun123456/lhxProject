package com.lhx.cache.ehcache.service;

import java.util.List;
import java.util.Map;

/**
 * 缓存服务接口
 * @author liangshu
 *
 */
public interface CacheService {
	
	public abstract boolean put(String key, Object object);
	
	public abstract boolean putAll(Map<String,?> cacheMap);

	public abstract void remove(String key);
	
	public boolean isExists(String key);
	
	public Object get(String key);
	
	public <T> T get(String key,Class<T> type);
	
	public <T> List<T> search(String searchKey,String searchFiled,Class<T> type);
}
