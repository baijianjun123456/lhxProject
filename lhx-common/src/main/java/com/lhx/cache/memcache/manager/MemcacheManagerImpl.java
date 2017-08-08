package com.lhx.cache.memcache.manager;

import java.util.List;
import java.util.Map;

import com.lhx.cache.CacheManager;
import com.lhx.cache.memcache.facotry.MemcacheFactory;

public class MemcacheManagerImpl implements CacheManager{
	
	private String cacheName = "DeaultData";
	
	public MemcacheManagerImpl(){
	}
	
	public MemcacheManagerImpl(String cacheName){
			this.cacheName = cacheName;
	}

	public Object get(String key)
	{
	    return MemcacheFactory.newInstance().getCacheService(cacheName).get(key);
	 }

	@Override
	public boolean put(String key, Object object) {
		return MemcacheFactory.newInstance().getCacheService(cacheName).put(key, object);
	}

	@Override
	public void remove(String key) {
		MemcacheFactory.newInstance().getCacheService(cacheName).remove(key);
	}

	@Override
	public boolean isExists(String key) {
		return  MemcacheFactory.newInstance().getCacheService(cacheName).isExists(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String key, Class<T> type) {
	
		return (T)get(key);
	}
	
	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	@Override
	public boolean putAll(Map<String, ?> cacheMap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> List<T> search(String key,String searchFiled,Class<T> type) {
		// TODO Auto-generated method stub,Class<T> type
		return null;
	}
}
