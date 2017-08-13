package com.lhx.cache.redis.service;

import java.util.List;
import java.util.Map;

public interface RedisClusterService {

	public String get(String key);
	
	public String set(String key, String value);
    
	public String set(String key, int value);

	public Long del(String key);

	public int hget(String key, String field);

	public Long hset(String key, String field, int value);

	public Long hset(String key, String field, String value);

	public Long hdel(String key, String... fields);
	
	public String hmset(String key, Map<String, String> hash);
	
	public List<String> hmget(String key, String... fields);
	
	public boolean exists(String key);

	public Long append(String key, String value);
	
	public Long setnx(String key, String value);
	
	public String setex(String key, int seconds, String value);
	
	public Long setrange(String key, long offset, String value);
	
	public Long expire(String key, int seconds);
        
	public void close();
	
}
