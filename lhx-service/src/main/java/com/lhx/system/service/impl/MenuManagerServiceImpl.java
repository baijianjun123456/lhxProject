package com.lhx.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lhx.system.service.constants.SystemConstants;
import com.lhx.system.service.MenuManagerService;
import com.lhx.system.menu.dao.MenuDao;
import com.lhx.system.menu.model.Menu;
import com.lhx.system.menu.model.MenuQuery;

@Service
public class MenuManagerServiceImpl implements MenuManagerService {
	
    @Autowired
	private MenuDao  menuDao;
    
	@Override
	public boolean addMenu(Menu menu_) {
		menuDao.save(menu_);
		return true;
	}

	@Override
	public boolean removeMenu(Menu menu_, boolean flag) {
		if(flag){
			menuDao.delete(menu_.getId_());
		}
		else{
			menu_.setStatus(SystemConstants.DELETE_STATE);
			menuDao.update(menu_);
		}
		return true;
	}

	@Override
	public int updateMenu(Menu menu_) {
		
		return menuDao.update(menu_);
	}
	
	public Menu get(Menu menu_){
		List<Menu> menuList = menuDao.queryList(menu_);
		return (menuList == null || menuList.size() <= 0) ? null : menuList.get(0);
	}
	
	public List<Menu> getList(Menu menu_){
		return menuDao.queryList(menu_);
	}
	
	public List<Menu> getListPage(MenuQuery menuQuery){
		return menuDao.queryListPage(menuQuery);
	}
	
	public Menu get(String id_){
		return menuDao.query(id_);
	}

}
