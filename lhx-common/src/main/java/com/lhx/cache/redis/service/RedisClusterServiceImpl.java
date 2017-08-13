package com.lhx.cache.redis.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.lhx.logging.Log;
import com.lhx.logging.LogFactory;
import com.lhx.utils.PropertiesUtils;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClusterServiceImpl implements RedisClusterService,InitializingBean{
	
	private static Log logger = LogFactory.getLogger(RedisClusterServiceImpl.class);

    private JedisCluster jedisCluster;
    
    public static RedisClusterService newInstance(String cacheName){
		return new RedisClusterServiceImpl(cacheName);
	}
    
    private void initCluster(String cacheName)
	{
    	this.afterPropertiesSet();
    	//连接的超时时间
    	Integer connectionTimeout = Integer.parseInt(PropertiesUtils.getProperties("redis.connectionTimeout"));
    	//socket调用InputStream读数据的超时时间
    	Integer soTimeout = Integer.parseInt(PropertiesUtils.getProperties("redis.soTimeout"));
    	//重试次数
    	Integer maxAttempts = Integer.parseInt(PropertiesUtils.getProperties("redis.maxAttempts"));
	    logger.debug("初始化Redis:"+cacheName+"缓存连接池设置");
	    Set<HostAndPort> clusterNodes = new HashSet<HostAndPort>();
	    JedisPoolConfig config = new JedisPoolConfig();
	    config.setMaxTotal(100);//最大活动的对象个数
	    config.setMaxIdle(30);//对象最大空闲时间
	    config.setMaxWaitMillis(15000);//获取对象时最大等待时间
	    clusterNodes.add(new HostAndPort(PropertiesUtils.getProperties("redis.host1"),Integer.parseInt(PropertiesUtils.getProperties("redis.port1"))));
	    clusterNodes.add(new HostAndPort(PropertiesUtils.getProperties("redis.host2"),Integer.parseInt(PropertiesUtils.getProperties("redis.port2"))));
	    clusterNodes.add(new HostAndPort(PropertiesUtils.getProperties("redis.host3"),Integer.parseInt(PropertiesUtils.getProperties("redis.port3"))));
	    jedisCluster = new JedisCluster(clusterNodes, connectionTimeout,soTimeout, maxAttempts, config);
	    
	}
	
	public RedisClusterServiceImpl(String cacheName){
		if(jedisCluster == null){
			initCluster(cacheName);
		}
	}
    

	@Override
	public String get(String key) {
		String value = "";
		try {
			value = jedisCluster.get(key);
			value = value == null ? "" : value;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return value;
	}

	@Override
	public String set(String key, String value) {
		String result = "";
		try {
			result = jedisCluster.set(key, value);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	@Override
	public String set(String key, int value) {
		String result = "";
		try {
			result = jedisCluster.set(key, String.valueOf(value));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	@Override
	public Long del(String key) {
		Long result = 0L;
		try {
			result = jedisCluster.del(key);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	@Override
	public int hget(String key, String field) {
		String value = "0";
		try {
			value = jedisCluster.hget(key, field);
			value = value == null ? "0" : value;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return Integer.parseInt(value);
	}

	@Override
	public Long hset(String key, String field, int value) {
		Long result = 0L;
		try {
			result = jedisCluster.hset(key, field, value + "");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	@Override
	public Long hset(String key, String field, String value) {
		Long result = 0L;
		try {
			result = jedisCluster.hset(key, field, value);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	@Override
	public Long hdel(String key, String... fields) {
		Long result = 0L;
		try {
			result = jedisCluster.hdel(key, fields);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	@Override
	public String hmset(String key, Map<String, String> hash) {
		String result = "";
		try {
			result = jedisCluster.hmset(key, hash);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	@Override
	public List<String> hmget(String key, String... fields) {
		List<String> result = new ArrayList<String>();
		try {
			result = jedisCluster.hmget(key, fields);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean exists(String key) {
		Boolean result = false;
        if (jedisCluster == null) {
            return result;
        }
        try {
            result = jedisCluster.exists(key);
        } catch (Exception e) {
        	logger.error(e.getMessage());
        }
        return result;
	}
	
	public Long append(String key, String value){
		Long result = 0L;
		try {
			result = jedisCluster.append(key, value);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	public Long setnx(String key, String value){
		Long result = 0L;
		try {
			result = jedisCluster.setnx(key, value);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	public String setex(String key, int seconds, String value){
		String result = "";
		try {
			result = jedisCluster.setex(key, seconds, value);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	public Long setrange(String key, long offset, String value){
		Long result = 0L;
		try {
			result = jedisCluster.setrange(key, offset, value);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	public Long expire(String key, int seconds){
		Long result = 0L;
        try {
            result = jedisCluster.expire(key, seconds);
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
        return result;
	}
	
	@Override
	public void close() {
		try {
			if (jedisCluster != null) {
				jedisCluster.close();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public void afterPropertiesSet() {
		PropertiesUtils.loadProperties(RedisClusterServiceImpl.class.getResourceAsStream("redis.properties"));
	}

}
