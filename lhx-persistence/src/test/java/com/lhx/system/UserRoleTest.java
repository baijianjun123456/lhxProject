package com.lhx.system;

import java.util.List;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import com.lhx.base.BaseTest;
import com.lhx.system.userRole.dao.UserRoleDao;
import com.lhx.system.userRole.model.UserRole;
import com.lhx.utils.SpringConfigTool;
import com.lhx.utils.UUIDUtil;

public class UserRoleTest extends BaseTest{
	
	@Test
	public void add() {
		UserRoleDao userRoleDao = (UserRoleDao)SpringConfigTool.getBean("userRoleDao");
		UserRole userRole = UserRole.newInstance(UUIDUtil.getUUID(), UUIDUtil.getUUID(), UUIDUtil.getUUID());
		userRoleDao.save(userRole);
	}
	
	@Test
	public void query() {
		UserRoleDao userRoleDao = (UserRoleDao)SpringConfigTool.getBean("userRoleDao");
		UserRole userRole = new UserRole();
		List<UserRole> userRoleList = userRoleDao.queryList(userRole);
		if(!CollectionUtils.isEmpty(userRoleList)){
			userRoleDao.query(userRoleList.get(0).getId_());
		}
	}

	
	@Test
	public void queryList() {
		UserRoleDao userRoleDao = (UserRoleDao)SpringConfigTool.getBean("userRoleDao");
		UserRole userRole = new UserRole();
		userRoleDao.queryList(userRole);
	}

	
	@Test
	public void update() {
		UserRoleDao userRoleDao = (UserRoleDao)SpringConfigTool.getBean("userRoleDao");
		UserRole userRole = new UserRole();
		List<UserRole> userRoleList = userRoleDao.queryList(userRole);
		if(!CollectionUtils.isEmpty(userRoleList)){
			UserRole userRoleU = new UserRole();
			userRoleU.setId_(userRoleList.get(0).getId_());
			userRoleU.setRoleId("11111111");
			userRoleDao.update(userRoleU);
		}
	}

	@Test
	public void delete() {
		UserRoleDao userRoleDao = (UserRoleDao)SpringConfigTool.getBean("userRoleDao");
		UserRole userRole = new UserRole();
		List<UserRole> userRoleList = userRoleDao.queryList(userRole);
		userRoleDao.delete(userRoleList.get(0).getId_());
	}

}
