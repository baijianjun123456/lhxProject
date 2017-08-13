package com.lhx.cache.redis.manager;

import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.lhx.cache.CacheManager;
import com.lhx.cache.redis.factory.RedisClusterFactory;

public class RedisClusterManager implements CacheManager{

private String cacheName = "DeaultRedisData";
	
	public RedisClusterManager(){
	}
	
	public RedisClusterManager(String cacheName){
			this.cacheName = cacheName;
	}
	
	@Override
	public Object get(String key) {
		return RedisClusterFactory.newInstance().getCacheService(cacheName).get(key);
	}
	
	@Override
	public boolean put(String key, Object obj) {
		String strValue = RedisClusterFactory.newInstance().getCacheService(cacheName).set(key, String.valueOf(obj));
		return !StringUtils.isEmpty(strValue);
	}

	@Override
	public void remove(String key) {
		long inst = RedisClusterFactory.newInstance().getCacheService(cacheName).del(key);
	}

	@Override
	public boolean isExists(String key) {
		return RedisClusterFactory.newInstance().getCacheService(cacheName).exists(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String key, Class<T> type) {
		return (T)get(key);
	}

	@Override
	public boolean putAll(Map<String, ?> cacheMap) {
		return false;
	}

	@Override
	public <T> List<T> search(String searchKey, String searchFiled, Class<T> type) {
		return null;
	}

	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

}
