package com.lhx.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lhx.system.service.constants.SystemConstants;
import com.lhx.system.service.FormDefManagerService;
import com.lhx.system.formDef.dao.FormDefDao;
import com.lhx.system.formDef.model.FormDef;
import com.lhx.system.formDef.model.FormDefQuery;

@Service
public class FormDefManagerServiceImpl implements FormDefManagerService {
	
    @Autowired
	private FormDefDao  formDefDao;
    
	@Override
	public boolean addFormDef(FormDef formDef_) {
		formDefDao.save(formDef_);
		return true;
	}

	@Override
	public boolean removeFormDef(FormDef formDef_, boolean flag) {
		if(flag){
			formDefDao.delete(formDef_.getId_());
		}
		else{
			formDef_.setStatus(SystemConstants.DELETE_STATE);
			formDefDao.update(formDef_);
		}
		return true;
	}

	@Override
	public int updateFormDef(FormDef formDef_) {
		
		return formDefDao.update(formDef_);
	}
	
	public FormDef get(FormDef formDef_){
		List<FormDef> formDefList = formDefDao.queryList(formDef_);
		return (formDefList == null || formDefList.size() <= 0) ? null : formDefList.get(0);
	}
	
	public List<FormDef> getList(FormDef formDef_){
		return formDefDao.queryList(formDef_);
	}
	
	public List<FormDef> getListPage(FormDefQuery formDefQuery){
		return formDefDao.queryListPage(formDefQuery);
	}
	
	public FormDef get(String id_){
		return formDefDao.query(id_);
	}
}
