package com.lhx.common.service.tree.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhx.common.service.tree.TreeService;
import com.lhx.common.tree.FormTypeTreeModel;
import com.lhx.system.formDef.dao.FormDefDao;

@Service("formTypeTreeServiceImpl")
public class FormTypeTreeServiceImpl implements TreeService<FormTypeTreeModel> {
	
	@Autowired
	private FormDefDao  formDefDao;
	
	@Override
	public List<FormTypeTreeModel> createTree(Map<String,String> param) {
		return formDefDao.queryformTypeAllTree();
	}

}
