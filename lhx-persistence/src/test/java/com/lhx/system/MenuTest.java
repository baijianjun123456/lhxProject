package com.lhx.system;

import java.util.List;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import com.lhx.base.BaseTest;
import com.lhx.system.menu.dao.MenuDao;
import com.lhx.system.menu.model.Menu;
import com.lhx.utils.SpringConfigTool;
import com.lhx.utils.UUIDUtil;

public class MenuTest  extends BaseTest{

	@Test
	public void add() {
		MenuDao menuDao = (MenuDao)SpringConfigTool.getBean("menuDao");
		String id_ = UUIDUtil.getUUID();
		Menu menu = Menu.newInstance(id_,"系统菜单","10000","1");
		menuDao.save(menu);
	}
	
	@Test
	public void query() {
		MenuDao menuDao = (MenuDao)SpringConfigTool.getBean("menuDao");
		Menu menu = new Menu();
		List<Menu> menuList = menuDao.queryList(menu);
		if(!CollectionUtils.isEmpty(menuList)){
			menuDao.query(menuList.get(0).getId_());
		}
	}

	
	@Test
	public void queryList() {
		MenuDao menuDao = (MenuDao)SpringConfigTool.getBean("menuDao");
		Menu menu = new Menu();
	    menuDao.queryList(menu);
	}

	
	@Test
	public void update() {
		MenuDao menuDao = (MenuDao)SpringConfigTool.getBean("menuDao");
		Menu menu = new Menu();
		List<Menu> menuList = menuDao.queryList(menu);
		if(!CollectionUtils.isEmpty(menuList)){
			Menu menuu = new Menu();
			menuu.setName("系统菜单1");
			menuDao.update(menuu);
		}
	}

	@Test
	public void delete() {
		MenuDao menuDao = (MenuDao)SpringConfigTool.getBean("menuDao");
		Menu menu = new Menu();
		List<Menu> menuList = menuDao.queryList(menu);
		menuDao.delete(menuList.get(0).getId_());
	}

}
