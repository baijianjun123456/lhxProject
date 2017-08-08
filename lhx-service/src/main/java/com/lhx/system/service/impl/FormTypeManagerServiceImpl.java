package com.lhx.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lhx.system.service.constants.SystemConstants;
import com.lhx.system.service.FormTypeManagerService;
import com.lhx.system.formType.dao.FormTypeDao;
import com.lhx.system.formType.model.FormType;
import com.lhx.system.formType.model.FormTypeQuery;

@Service
public class FormTypeManagerServiceImpl implements FormTypeManagerService {
	
    @Autowired
	private FormTypeDao  formTypeDao;
    
	@Override
	public boolean addFormType(FormType formType_) {
		formTypeDao.save(formType_);
		return true;
	}

	@Override
	public boolean removeFormType(FormType formType_, boolean flag) {
		if(flag){
			formTypeDao.delete(formType_.getId_());
		}
		else{
			formType_.setStatus(SystemConstants.DELETE_STATE);
			formTypeDao.update(formType_);
		}
		return true;
	}

	@Override
	public int updateFormType(FormType formType_) {
		return formTypeDao.update(formType_);
	}
	
	public FormType get(FormType formType_){
		List<FormType> formTypeList = formTypeDao.queryList(formType_);
		return (formTypeList == null || formTypeList.size() <= 0) ? null : formTypeList.get(0);
	}
	
	public List<FormType> getList(FormType formType_){
		return formTypeDao.queryList(formType_);
	}
	
	public List<FormType> getListPage(FormTypeQuery formTypeQuery){
		return formTypeDao.queryListPage(formTypeQuery);
	}
	
	public FormType get(String id_){
		return formTypeDao.query(id_);
	}

}
