package com.lhx.stock.service;

import java.util.List;
import com.lhx.stock.info.model.StockInfo;
import com.lhx.stock.info.model.StockInfoQuery;

/**
 * 股票基础信息表管理相关服务接口
 * @author liangshu
 *
 */
public interface StockInfoManagerService {
	
	/**
	 * 添加新股票基础信息表；
	 * @param user：新增股票基础信息表目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addStockInfo(StockInfo stockInfo_);
	
	/**
	 * 删除股票基础信息表；
	 * @param user_:删除目标股票基础信息表对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removeStockInfo(StockInfo stockInfo_,boolean flag);
	
	/**
	 * 更新股票基础信息表信息；
	 * @param user_：更新目标股票基础信息表对象信息；
	 * @return : 被更新股票基础信息表的总条数
	 */ 
	public  int  updateStockInfo(StockInfo stockInfo_);
	
	public List<StockInfo> getList(StockInfo stockInfo);

	/**
	 * 查询股票基础信息表列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<StockInfo> getListPage(StockInfoQuery stockInfoQuery);
	
	
	public StockInfo get(String id_);
	
}
