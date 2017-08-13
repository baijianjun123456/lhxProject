package com.lhx.system;

import java.util.List;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import com.lhx.base.BaseTest;
import com.lhx.system.userOrg.dao.UserOrgDao;
import com.lhx.system.userOrg.model.UserOrg;
import com.lhx.utils.SpringConfigTool;
import com.lhx.utils.UUIDUtil;

public class UserOrgTest extends BaseTest{
	
	@Test
	public void add() {
		UserOrgDao userOrgDao = (UserOrgDao)SpringConfigTool.getBean("userOrgDao");
		UserOrg userOrg = UserOrg.newInstance(UUIDUtil.getUUID(), UUIDUtil.getUUID(), UUIDUtil.getUUID());
		userOrgDao.save(userOrg);
	}
	
	@Test
	public void query() {
		UserOrgDao userOrgDao = (UserOrgDao)SpringConfigTool.getBean("userOrgDao");
		UserOrg userOrg = new UserOrg();
		List<UserOrg> userOrgList = userOrgDao.queryList(userOrg);
		if(!CollectionUtils.isEmpty(userOrgList)){
			userOrgDao.query(userOrgList.get(0).getId_());
		}
	}

	
	@Test
	public void queryList() {
		UserOrgDao userOrgDao = (UserOrgDao)SpringConfigTool.getBean("userOrgDao");
		UserOrg userOrg = new UserOrg();
		userOrgDao.queryList(userOrg);
	}

	
	@Test
	public void update() {
		UserOrgDao userOrgDao = (UserOrgDao)SpringConfigTool.getBean("userOrgDao");
		UserOrg userOrg = new UserOrg();
		List<UserOrg> userOrgList = userOrgDao.queryList(userOrg);
		if(!CollectionUtils.isEmpty(userOrgList)){
			UserOrg userOrgq = new UserOrg();
			userOrgq.setId_(userOrgList.get(0).getId_());
			userOrgq.setOrgId("11111111");
			userOrgDao.update(userOrgq);
		}
	}

	@Test
	public void delete() {
		UserOrgDao userOrgDao = (UserOrgDao)SpringConfigTool.getBean("userOrgDao");
		UserOrg userOrg = new UserOrg();
		List<UserOrg> userOrgList = userOrgDao.queryList(userOrg);
		userOrgDao.delete(userOrgList.get(0).getId_());
	}

}
