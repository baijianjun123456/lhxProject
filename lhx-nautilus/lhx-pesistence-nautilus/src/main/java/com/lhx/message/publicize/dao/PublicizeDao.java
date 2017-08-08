package com.lhx.message.publicize.dao;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.message.publicize.model.Publicize;
import com.lhx.message.publicize.model.PublicizeQuery;

/**
 * 发布公告表持久化接口；
 * @author liangshu
 */
public interface PublicizeDao extends SuperDao,BaseDao<Publicize,PublicizeQuery> {

}
