package com.lhx.system.form.dao;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.system.form.model.Form;
import com.lhx.system.form.model.FormQuery;

/**
 * 表单管理持久化接口；
 * @author liangshu
 */
public interface FormDao extends SuperDao,BaseDao<Form,FormQuery> {
	
	public void deleteByTableName(String tableName);

}
