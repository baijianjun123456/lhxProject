package com.lhx.message.attach.dao;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.message.attach.model.Attach;
import com.lhx.message.attach.model.AttachQuery;

/**
 * 附件表持久化接口；
 * @author liangshu
 */
public interface AttachDao extends SuperDao,BaseDao<Attach,AttachQuery> {

}
