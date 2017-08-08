package com.lhx.message.sendrecord.dao;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.message.sendrecord.model.SERecord;
import com.lhx.message.sendrecord.model.SERecordQuery;

/**
 * 发送记录持久化接口；
 * @author liangshu
 */
public interface SERecordDao extends SuperDao,BaseDao<SERecord,SERecordQuery> {

}
