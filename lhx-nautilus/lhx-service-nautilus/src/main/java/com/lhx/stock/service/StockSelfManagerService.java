package com.lhx.stock.service;

import java.util.List;

import com.lhx.stock.info.model.StockInfo;
import com.lhx.stock.self.model.StockSelf;
import com.lhx.stock.self.model.StockSelfQuery;

/**
 * 自选股管理相关服务接口
 * @author liangshu
 *
 */
public interface StockSelfManagerService {
	
	/**
	 * 添加新自选股；
	 * @param user：新增自选股目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addStockSelf(StockSelf stockSelf_);
	
	/**
	 * 删除自选股；
	 * @param user_:删除目标自选股对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removeStockSelf(StockSelf stockSelf_,boolean flag);
	
	/**
	 * 更新自选股信息；
	 * @param user_：更新目标自选股对象信息；
	 * @return : 被更新自选股的总条数
	 */ 
	public  int  updateStockSelf(StockSelf stockSelf_);
	
	public List<StockSelf> getList(StockSelf stockSelf);

	/**
	 * 查询自选股列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<StockSelf> getListPage(StockSelfQuery stockSelfQuery);
	
	
	public StockSelf get(String id_);
	
	/**
	 * 是否是自选股票
	 * @return
	 */
	public boolean isSelf(StockSelf stockSelf_);
}
