package com.lhx.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhx.common.mybatis.dao.TabColDao;
import com.lhx.file.model.TabColModel;
import com.lhx.system.service.constants.SystemConstants;
import com.lhx.system.service.FormManagerService;
import com.lhx.system.form.dao.FormDao;
import com.lhx.system.form.model.Form;
import com.lhx.system.form.model.FormQuery;

@Service
public class FormManagerServiceImpl implements FormManagerService {
	
    @Autowired
	private FormDao  formDao;
    
    @Autowired
    private TabColDao tabColDao;
    
	@Override
	public boolean addForm(Form form_) {
		formDao.save(form_);
		return true;
	}

	@Override
	public boolean removeForm(Form form_, boolean flag) {
		if(flag){
			formDao.delete(form_.getId_());
		}
		else{
			form_.setStatus(SystemConstants.DELETE_STATE);
			formDao.update(form_);
		}
		return true;
	}

	@Override
	public int updateForm(Form form_) {
		
		return 0;
	}
	
	public Form get(Form form_){
		List<Form> formList = formDao.queryList(form_);
		return (formList == null || formList.size() <= 0) ? null : formList.get(0);
	}
	
	public List<Form> getList(Form form_){
		return formDao.queryList(form_);
	}
	
	public List<Form> getListPage(FormQuery formQuery){
		return formDao.queryListPage(formQuery);
	}
	
	/**
	 * 查询数据库表列表
	 * @return
	 */
	public List<Map<String,String>> getTableList(){
		return tabColDao.queryTableList();
	}
	
	/**
	 * 根据表名获取列定义信息
	 * @param tableName
	 * @return
	 */
	public List<TabColModel> getColList(String tableName){
		return tabColDao.queryFiledList(tableName);
	}
	
	public void initFormFiled(TabColModel tabColModel){
		List<TabColModel> tabColModelList = tabColDao.queryList(tabColModel);
		
		formDao.deleteByTableName(tabColModel.getTableName());
		for(TabColModel filedModel : tabColModelList){
			formDao.save(Form.convert(filedModel));
		}
	}
}
