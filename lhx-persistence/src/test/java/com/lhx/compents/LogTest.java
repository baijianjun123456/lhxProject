package com.lhx.compents;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.Test;


public class LogTest {
	
	private Log log = LogFactory.getLog(LogTest.class);
	
	class User{
		private String userId;
		
		private String userName;
		
		public User(String userId,String userName){
			this.userId = userId;
			this.userName = userName;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}
	}


	@Test
	public void test() {
		List<Map<String,User>> testList = new ArrayList<Map<String,User>>();
		Map<String,User> test1Map = new HashMap<String,User>();
		User user1 = new User("userId1","userName1");
		User user2 = new User("userId2","userName2");
		User user3 = new User("userId3","userName3");
		test1Map.put("user1", user1);
		test1Map.put("user2", user2);
		test1Map.put("user3", user3);
		testList.add(test1Map);

		Map<String,User> test2Map = new HashMap<String,User>();
		User user11 = new User("userId1","userName1");
		User user22 = new User("userId2","userName2");
		User user33 = new User("userId3","userName3");
		test2Map.put("user11", user11);
		test2Map.put("user22", user22);
		test2Map.put("user33", user33);
		testList.add(test2Map);
		
		log.debug("55555");
	}

}
