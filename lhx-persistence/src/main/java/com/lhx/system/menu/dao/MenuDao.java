package com.lhx.system.menu.dao;

import java.util.List;
import java.util.Map;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.common.tree.MenuTreeModel;
import com.lhx.system.menu.model.Menu;
import com.lhx.system.menu.model.MenuQuery;

/**
 * 菜单持久化接口；
 * @author liangshu
 */
public interface MenuDao extends SuperDao,BaseDao<Menu,MenuQuery> {
	
	public List<MenuTreeModel> queryMenuAllTree();
	
	public List<MenuTreeModel> queryMenuAllTreeByRole(Map<String,String> param);

}
