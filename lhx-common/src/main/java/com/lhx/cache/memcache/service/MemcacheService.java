package com.lhx.cache.memcache.service;

public interface MemcacheService {
	
	public abstract boolean put(String key, Object object);

	public abstract void remove(String key);
	
	public boolean isExists(String key);
	
	public Object get(String key);
	
	public <T> T get(String key,Class<T> type);
}
