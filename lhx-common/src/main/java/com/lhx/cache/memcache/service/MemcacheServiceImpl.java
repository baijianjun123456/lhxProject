package com.lhx.cache.memcache.service;

import org.springframework.beans.factory.InitializingBean;
import com.danga.MemCached.MemCachedClient;
import com.lhx.cache.memcache.facotry.MemcacheFactory;
import com.lhx.cache.memcache.manager.MemcacheManagerImpl;
import com.lhx.logging.Log;
import com.lhx.logging.LogFactory;
import com.lhx.utils.PropertiesUtils;
import com.schooner.MemCached.SchoonerSockIOPool;

public class MemcacheServiceImpl implements MemcacheService,InitializingBean {
	
	private static Log logger = LogFactory.getLogger(MemcacheFactory.class);
	  
	private MemCachedClient client;

	private void init(String cacheName)
	{
	    logger.debug("初始化memecahced:"+cacheName+"缓存连接池设置");

	    String[] servers = PropertiesUtils.getProperties("memcahce.servers").split(";");
	    SchoonerSockIOPool pool = SchoonerSockIOPool.getInstance(cacheName);
	    pool.setServers(servers);
	    pool.setHashingAlg(32);
	    pool.setFailover("1".equals(PropertiesUtils.getProperties("memcahce.failover")));
	    pool.setInitConn(Integer.parseInt(PropertiesUtils.getProperties("memcahce.initConn")));
	    pool.setMinConn(Integer.parseInt(PropertiesUtils.getProperties("memcahce.minConn")));
	    pool.setMaxConn(Integer.parseInt(PropertiesUtils.getProperties("memcahce.maxConn")));
	    pool.setMaintSleep(30L);
	    pool.setNagle("1".equals(PropertiesUtils.getProperties("memcahce.nagle")));
	    pool.setSocketTO(Integer.parseInt(PropertiesUtils.getProperties("memcahce.socketTO")));
	    pool.setAliveCheck("1".equals(PropertiesUtils.getProperties("memcahce.aliveCheck")));
	    pool.initialize();
	    this.client = new MemCachedClient(cacheName);
	}
	
	private MemcacheServiceImpl(String cacheName)
	{
	    init(cacheName);
	}

	@Override
	public Object get(String key) {
		return this.client.get(key);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String key, Class<T> type) {
		return (T)get(key);
	}

	@Override
	public boolean put(String key, Object obj) {
	    return this.client.set(key, obj);

	}

	@Override
	public void remove(String key) {
		this.client.delete(key);
	}

	@Override
	public boolean isExists(String key) {
		return this.client.keyExists(key);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		PropertiesUtils.load("/config/memcahce.properties",MemcacheManagerImpl.class.getClassLoader());
	}

}
