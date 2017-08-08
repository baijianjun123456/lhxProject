package com.lhx.message.receiverecord.dao;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.message.receiverecord.model.RERecord;
import com.lhx.message.receiverecord.model.RERecordQuery;

/**
 * 接收记录持久化接口；
 * @author liangshu
 */
public interface RERecordDao extends SuperDao,BaseDao<RERecord,RERecordQuery> {

}
