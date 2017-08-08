package com.lhx.system.user.dao;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.system.user.model.User;
import com.lhx.system.user.model.UserQuery;

/**
 * 用户持久化接口；
 * @author liangshu
 */
public interface UserDao extends SuperDao,BaseDao<User,UserQuery> {

}
