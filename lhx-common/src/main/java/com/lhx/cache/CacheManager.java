package com.lhx.cache;

import java.util.List;
import java.util.Map;

public interface CacheManager {
	
	public Object get(String key);
	
	public abstract boolean put(String key, Object object);

	public abstract void remove(String key);
	
	public boolean isExists(String key);
	
	public <T> T get(String key,Class<T> type);
	
	public boolean  putAll(Map<String, ?> cacheMap);
	
	public <T> List<T> search(String searchKey,String searchFiled,Class<T> type);
	
	public String getCacheName();

	public void setCacheName(String cacheName);
}
