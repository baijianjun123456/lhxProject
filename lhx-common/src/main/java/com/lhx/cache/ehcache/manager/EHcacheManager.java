package com.lhx.cache.ehcache.manager;

import java.util.List;
import java.util.Map;
import com.lhx.cache.CacheManager;
import com.lhx.cache.ehcache.factory.EHcacheFactory;

public class EHcacheManager implements CacheManager{
	
	private String cacheName = "DeaultData";
	
	public EHcacheManager(){
	}
	
	public EHcacheManager(String cacheName){
			this.cacheName = cacheName;
	}

	public Object get(String key)
	{
	    return EHcacheFactory.newInstance().getCacheService(cacheName).get(key);
	 }

	@Override
	public boolean put(String key, Object object) {
		return EHcacheFactory.newInstance().getCacheService(cacheName).put(key, object);
	}

	@Override
	public void remove(String key) {
		 EHcacheFactory.newInstance().getCacheService(cacheName).remove(key);
	}

	@Override
	public boolean isExists(String key) {
		return  EHcacheFactory.newInstance().getCacheService(cacheName).isExists(key);
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
		EHcacheFactory.newInstance().getCacheService(cacheName).putAll(cacheMap);
		return true;
	}

	@Override
	public <T> List<T> search(String searchKey,String searchFiled,Class<T> type) {
		return EHcacheFactory.newInstance().getCacheService(cacheName).search(searchKey,searchFiled,type);
	}
}
