package com.lhx.cache.memcache.facotry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.lhx.cache.ehcache.factory.EHcacheFactory;
import com.lhx.cache.ehcache.service.CacheService;
import com.lhx.cache.ehcache.service.EHcacheServiceImpl;


public class MemcacheFactory {
	
	private static volatile EHcacheFactory cacheFactory;
	
	private Map<String,CacheService> cacheMap = null;
	

	public MemcacheFactory(){
	    this.cacheMap = new ConcurrentHashMap<String, CacheService>();
	}
	
	public static EHcacheFactory newInstance(){
		if (cacheFactory == null) {
	      synchronized (EHcacheFactory.class) {
	        if (cacheFactory == null) {
	        	cacheFactory = new EHcacheFactory();
	        }
	      }
	    }
		return cacheFactory;
	}

	public CacheService getCacheService(String name)
	{   
		CacheService cacheService = null;
	    if (this.cacheMap.containsKey(name)) {
	      return this.cacheMap.get(name);
	    }
	    synchronized (EHcacheFactory.class) {
	       cacheService = EHcacheServiceImpl.newInstance(name);
	       this.cacheMap.put(name,cacheService );
	    }
	    return cacheService;
	}


}
