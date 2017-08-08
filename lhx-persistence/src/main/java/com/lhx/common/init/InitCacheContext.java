package com.lhx.common.init;

import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import com.lhx.cache.utils.CacheUtil;
import com.lhx.system.dict.dao.DictDao;
import com.lhx.system.dict.model.Dict;
import com.lhx.utils.LocalUtile;
import com.lhx.utils.SpringConfigTool;

/**
 * 缓存初始化类；
 * @author liangshu
 *
 */
public class InitCacheContext implements InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		
		//初始化缓存字典；
		initDict();
	}
	
	private void initDict(){
		
		DictDao dictDao = (DictDao)SpringConfigTool.getBean("dictDao");
		 
		Map<String, Dict> dictMap = dictDao.queryCacheDict(LocalUtile.getLocal());
				
		CacheUtil.getDictCache().putAll(dictMap);
	}
	
}
