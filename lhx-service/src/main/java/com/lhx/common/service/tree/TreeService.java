package com.lhx.common.service.tree;

import java.util.List;
import java.util.Map;

/**
 * 树服务的接口类
 * @author liangshu
 *
 */
public interface TreeService<T>{
	
	public List<T> createTree(Map<String,String> param);

}
