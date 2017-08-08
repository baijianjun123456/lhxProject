package com.lhx.system.org.dao;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.system.org.model.Org;
import com.lhx.system.org.model.OrgQuery;

/**
 * 组织机构持久化接口；
 * @author liangshu
 */
public interface OrgDao extends SuperDao,BaseDao<Org,OrgQuery> {

}
