package com.lhx.message.uploadsetting.dao;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.message.uploadsetting.model.UPloadsetting;
import com.lhx.message.uploadsetting.model.UPloadsettingQuery;

/**
 * 上传设置表持久化接口；
 * @author liangshu
 */
public interface UPloadsettingDao extends SuperDao,BaseDao<UPloadsetting,UPloadsettingQuery> {

}
