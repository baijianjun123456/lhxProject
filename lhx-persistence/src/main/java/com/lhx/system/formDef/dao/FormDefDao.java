package com.lhx.system.formDef.dao;

import java.util.List;

import com.lhx.common.mybatis.BaseDao;
import com.lhx.common.mybatis.SuperDao;
import com.lhx.common.tree.FormTypeTreeModel;
import com.lhx.system.formDef.model.FormDef;
import com.lhx.system.formDef.model.FormDefQuery;

/**
 * 表单定义持久化接口；
 * @author liangshu
 */
public interface FormDefDao extends SuperDao,BaseDao<FormDef,FormDefQuery> {
	
	public List<FormTypeTreeModel> queryformTypeAllTree();

}
