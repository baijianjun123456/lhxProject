package com.lhx.system.userOrg.dao;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.system.userOrg.model.UserOrg;
import com.lhx.system.userOrg.model.UserOrgQuery;

/**
 * 用户组织机构持久化接口；
 * @author liangshu
 */
public interface UserOrgDao extends SuperDao,BaseDao<UserOrg,UserOrgQuery> {

}
