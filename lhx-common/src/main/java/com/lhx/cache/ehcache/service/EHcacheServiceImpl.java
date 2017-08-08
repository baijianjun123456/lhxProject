package com.lhx.cache.ehcache.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;

import org.springframework.cache.ehcache.EhCacheCacheManager;

import com.lhx.utils.SpringConfigTool;

public class EHcacheServiceImpl implements CacheService {
	
	@Resource(name="cacheManager")
	private EhCacheCacheManager  cacheManager;
	
	private  Ehcache cache = null;
	
	public static CacheService newInstance(String cacheName){
		return new EHcacheServiceImpl(cacheName);
	}
	
	public void init(String cacheName){
		cacheManager = SpringConfigTool.getBean("cacheManager",EhCacheCacheManager.class);
		this.cache = cacheManager.getCacheManager().getCache(cacheName);
	}
	
	public EHcacheServiceImpl(String cacheName){
		init(cacheName);
	}

	@Override
	public boolean put(String key, Object obj) {
		Element element = new Element(key, obj); 
		this.cache.put(element);
		return true;
	}

	@Override
	public void remove(String key) {
		this.cache.remove(key);
	}

	@Override
	public boolean isExists(String key) {
		return this.cache.isKeyInCache(key);
	}

	@Override
	public Object get(String key) {
		Element elemet = this.cache.get(key);
		return elemet != null ? elemet.getObjectValue() : elemet;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T>  T get(String key,Class<T> type) {
		Object obj = this.get(key);
		return (T)obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> search(String searchKey,String searchFiled,Class<T> type) {
		Attribute<String> cacheKey = this.cache.getSearchAttribute(searchFiled);
		Query query = this.cache.createQuery();
		query.addCriteria(cacheKey.ilike(searchKey));
		query.includeValues();
		Results results = query.execute();
				
		// 获取Results中包含的所有的Result对象
		List<Result> resultList = results.all();
		
		List<T> TList = new ArrayList<T>();
		for(Result result : resultList){
			if (results.hasValues()) {
				TList.add((T)result.getValue());
			}
		}
		return TList;
	}
	
	@Override
	public boolean putAll(Map<String,?> cacheMap) {
		List<Element> elmentList = new ArrayList<Element>();
		for(String key : cacheMap.keySet()){
			Element element = new Element(key,cacheMap.get(key));
			elmentList.add(element);
		}
		this.cache.putAll(elmentList);
		return false;
	}

}
