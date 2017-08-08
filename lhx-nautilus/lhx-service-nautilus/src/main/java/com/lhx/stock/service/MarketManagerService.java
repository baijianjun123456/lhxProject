package com.lhx.stock.service;

import java.util.List;

import com.lhx.stock.market.model.Market;
import com.lhx.stock.market.model.MarketQuery;
import com.lhx.stock.model.EchartModel;

/**
 * 股票行情管理相关服务接口
 * @author liangshu
 *
 */
public interface MarketManagerService {
	
	/**
	 * 添加新股票行情；
	 * @param user：新增股票行情目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addMarket(Market market_);
	
	/**
	 * 删除股票行情；
	 * @param user_:删除目标股票行情对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removeMarket(Market market_,boolean flag);
	
	/**
	 * 更新股票行情信息；
	 * @param user_：更新目标股票行情对象信息；
	 * @return : 被更新股票行情的总条数
	 */ 
	public  int  updateMarket(Market market_);
	
	public List<Market> getList(Market market);

	/**
	 * 查询股票行情列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<Market> getListPage(MarketQuery marketQuery);
	
	
	public Market get(String id_);
	
	
	/**
	 * 创建图表数据模型；
	 * @param tcode：股票代码；
	 * @return
	 */
	public EchartModel createModel(String tcode);
}
