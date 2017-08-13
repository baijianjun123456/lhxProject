package com.lhx.compents;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lhx.base.BaseTest;
import com.lhx.cache.CacheManager;
import com.lhx.cache.redis.manager.RedisClusterManager;
import com.lhx.cache.utils.CacheUtil;
import com.lhx.system.dict.dao.DictDao;
import com.lhx.system.dict.model.Dict;
import com.lhx.utils.LocalUtile;
import com.lhx.utils.SpringConfigTool;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class RedisCacheTest extends BaseTest{
	
	private static final Logger logger = LogManager.getLogger(RedisCacheTest.class);
	

	@Test
	public void testRedis() {
		
	   //RedisClusterManager redis = new RedisClusterManager("DeaultRedisData");
		CacheManager redis = CacheUtil.getDictCache();
		
        //boolean flag = redis.put("test10", "0000000");
        System.out.println("是否存在： "+redis.isExists("test13"));
		System.out.println("打印缓存数据： "+redis.get("test13"));
		
	}

}
