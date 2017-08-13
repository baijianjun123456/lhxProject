package com.lhx.system;

import org.junit.Test;

import com.lhx.base.BaseTest;
import com.lhx.system.user.dao.UserDao;
import com.lhx.system.user.model.User;
import com.lhx.utils.EncryptUtil;
import com.lhx.utils.SpringConfigTool;
import com.lhx.utils.UUIDUtil;

public class UserTest extends BaseTest{
	
	private static String currentUserId = "";
	
	@Test
	public void add() {
		
		for(int i = 0 ; i < 30; i++){
			UserDao userDao = (UserDao)SpringConfigTool.getBean("userDao");
			currentUserId = UUIDUtil.getUUID();
			User user = User.newInstance(currentUserId, UUIDUtil.getUUID(), "0001003"+i, "000100010123", EncryptUtil.md5encrypt("123456"), "liangshu"+i, "liangshu"+i);
			user.setMobile("13789546236");
			userDao.save(user);
		}
		
	}
	
/*	@Test
	public void query() {
		UserDao userDao = (UserDao)SpringConfigTool.getBean("userDao");
		User user = new User();
		user.setAccounts("liangshu");
		List<User> userList = userDao.queryList(user);
		if(!CollectionUtils.isEmpty(userList)){
			userDao.query(userList.get(0).getId_());
		}
	}

	
	@Test
	public void queryList() {
		UserDao userDao = (UserDao)SpringConfigTool.getBean("userDao");
		User user = new User();
		user.setAccounts("liangshu");
		userDao.queryList(user);
	}

	
	@Test
	public void update() {
		UserDao userDao = (UserDao)SpringConfigTool.getBean("userDao");
		User user = new User();
		user.setAccounts("liangshu");
		List<User> userList = userDao.queryList(user);
		if(!CollectionUtils.isEmpty(userList)){
			user.setId_(userList.get(0).getId_());
			user.setAccounts("zhangsan");
			userDao.update(user);
		}
	}

	@Test
	public void delete() {
		UserDao userDao = (UserDao)SpringConfigTool.getBean("userDao");
		User user = new User();
		user.setName("liangshu");
		List<User> userList = userDao.queryList(user);
		userDao.delete(userList.get(0).getId_());
	}
*/

}
