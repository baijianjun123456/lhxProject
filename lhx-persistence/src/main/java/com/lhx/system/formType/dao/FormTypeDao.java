package com.lhx.system.formType.dao;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.system.formType.model.FormType;
import com.lhx.system.formType.model.FormTypeQuery;

/**
 * 表单分类持久化接口；
 * @author liangshu
 */
public interface FormTypeDao extends SuperDao,BaseDao<FormType,FormTypeQuery> {

}
