package com.lhx.cache.redis.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.lhx.cache.redis.service.RedisClusterService;
import com.lhx.cache.redis.service.RedisClusterServiceImpl;


public class RedisClusterFactory {
	
	private static volatile RedisClusterFactory redisFactory;
	
	private Map<String,RedisClusterService> redisMap = null;
	

	public RedisClusterFactory(){
	    this.redisMap = new ConcurrentHashMap<String, RedisClusterService>();
	}
	
	public static RedisClusterFactory newInstance(){
		if (redisFactory == null) {
	      synchronized (RedisClusterFactory.class) {
	        if (redisFactory == null) {
	        	redisFactory = new RedisClusterFactory();
	        }
	      }
	    }
		return redisFactory;
	}

	public RedisClusterService getCacheService(String name)
	{   
		RedisClusterService redisService = null;
	    if (this.redisMap.containsKey(name)) {
	      return this.redisMap.get(name);
	    }
	    synchronized (RedisClusterFactory.class) {
	    	redisService = RedisClusterServiceImpl.newInstance(name);
	       this.redisMap.put(name,redisService );
	    }
	    return redisService;
	}


}
