package com.lhx.system.service;

import java.util.List;
import com.lhx.system.menu.model.Menu;
import com.lhx.system.menu.model.MenuQuery;

/**
 * 菜单管理相关服务接口
 * @author liangshu
 *
 */
public interface MenuManagerService {
	
	/**
	 * 添加新菜单；
	 * @param user：新增菜单目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addMenu(Menu menu_);
	
	/**
	 * 删除菜单；
	 * @param user_:删除目标菜单对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removeMenu(Menu menu_,boolean flag);
	
	/**
	 * 更新菜单信息；
	 * @param user_：更新目标菜单对象信息；
	 * @return : 被更新菜单的总条数
	 */ 
	public  int  updateMenu(Menu menu_);
	
	public List<Menu> getList(Menu menu);

	/**
	 * 查询菜单列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<Menu> getListPage(MenuQuery menuQuery);
	
	
	public Menu get(String id_);
}
