package com.lhx.stock.service;

import java.util.Map;


/**
 * 指标管理相关服务接口
 * @author liangshu
 *
 */
public interface IndexManagerService {
	
	/**
	 * 计算指标信息
	 * @param param:指标计算相关参数；
	 */
	public void calculate(Map<String,String> param);
	
}
