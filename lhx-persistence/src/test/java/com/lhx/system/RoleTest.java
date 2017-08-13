package com.lhx.system;

import java.util.List;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import com.lhx.base.BaseTest;
import com.lhx.system.role.dao.RoleDao;
import com.lhx.system.role.model.Role;
import com.lhx.utils.SpringConfigTool;
import com.lhx.utils.UUIDUtil;

public class RoleTest extends BaseTest{

	@Test
	public void add() {
		RoleDao roleDao = (RoleDao)SpringConfigTool.getBean("roleDao");
		String id_ = UUIDUtil.getUUID();
		Role role = Role.newInstance(id_, "系统管理员","1","R_001");
		roleDao.save(role);
	}
	
	@Test
	public void query() {
		RoleDao roleDao = (RoleDao)SpringConfigTool.getBean("roleDao");
		Role role = new Role();
		role.setName("系统管理员");
		List<Role> roleList = roleDao.queryList(role);
		if(!CollectionUtils.isEmpty(roleList)){
			roleDao.query(roleList.get(0).getId_());
		}
	}

	
	@Test
	public void queryList() {
		RoleDao roleDao = (RoleDao)SpringConfigTool.getBean("roleDao");
		Role role = new Role();
		role.setName("系统管理员");
		roleDao.queryList(role);
	}

	
	@Test
	public void update() {
		RoleDao roleDao = (RoleDao)SpringConfigTool.getBean("roleDao");
		Role role = new Role();
		role.setName("系统管理员");
		List<Role> roleList = roleDao.queryList(role);
		if(!CollectionUtils.isEmpty(roleList)){
			role.setId_(roleList.get(0).getId_());
			role.setName("超级系统管理员");
			roleDao.update(role);
		}
	}

	@Test
	public void delete() {
		RoleDao roleDao = (RoleDao)SpringConfigTool.getBean("roleDao");
		Role role = new Role();
		role.setName("超级系统管理员");
		List<Role> roleList = roleDao.queryList(role);
		roleDao.delete(roleList.get(0).getId_());
	}

}
