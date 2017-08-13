package com.lhx.compents;

import java.util.Map;

import org.junit.Test;

import com.lhx.base.BaseTest;
import com.lhx.cache.utils.CacheUtil;
import com.lhx.system.dict.dao.DictDao;
import com.lhx.system.dict.model.Dict;
import com.lhx.utils.LocalUtile;
import com.lhx.utils.SpringConfigTool;

public class TestCache extends BaseTest{
	
/*	@Test
	public void testEHcache(){
		EHcacheManager manager = new EHcacheManager("DictData");
		
		manager.put("testKey", "testObj");
		
		System.out.println("打印缓存数据：testKey = "+manager.get("testKey"));
		
		manager.remove("testKey");
		
		System.out.println("打印缓存数据：testKey = "+manager.get("testKey"));

	}*/
	
	@Test
	public void testMemecache(){
		
		DictDao dictDao = (DictDao)SpringConfigTool.getBean("dictDao");
		 
		Map<String, Dict> dictMap = dictDao.queryCacheDict(LocalUtile.getLocal());
				
		CacheUtil.getDictCache().putAll(dictMap);
		
		System.out.println("打印缓存数据：testKey = "+CacheUtil.getDictCache().search("DATA_STATUS","pcode",Dict.class));

	}
}
