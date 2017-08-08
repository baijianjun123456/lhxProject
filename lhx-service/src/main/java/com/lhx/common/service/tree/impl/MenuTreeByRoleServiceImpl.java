package com.lhx.common.service.tree.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lhx.common.service.tree.TreeService;
import com.lhx.common.tree.MenuTreeModel;
import com.lhx.system.menu.dao.MenuDao;

@Service("MenuTreeByRoleService")
public class MenuTreeByRoleServiceImpl  implements TreeService<MenuTreeModel>{
	
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<MenuTreeModel> createTree(Map<String, String> param) {
		return menuDao.queryMenuAllTreeByRole(param);
	}

}
