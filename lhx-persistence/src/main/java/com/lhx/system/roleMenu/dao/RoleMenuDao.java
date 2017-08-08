package com.lhx.system.roleMenu.dao;

import java.util.List;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.system.roleMenu.model.RoleMenu;
import com.lhx.system.roleMenu.model.RoleMenuQuery;

/**
 * 角色菜单持久化接口；
 * @author liangshu
 */
public interface RoleMenuDao extends SuperDao,BaseDao<RoleMenu,RoleMenuQuery> {
	
	public void saveMore(List<RoleMenu> roleMenus);

}
