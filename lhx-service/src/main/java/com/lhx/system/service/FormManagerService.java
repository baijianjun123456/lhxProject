package com.lhx.system.service;

import java.util.List;
import java.util.Map;

import com.lhx.file.model.TabColModel;
import com.lhx.system.form.model.Form;
import com.lhx.system.form.model.FormQuery;

/**
 * 表单管理管理相关服务接口
 * @author liangshu
 *
 */
public interface FormManagerService {
	
	/**
	 * 添加新表单管理；
	 * @param user：新增表单管理目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addForm(Form form_);
	
	/**
	 * 删除表单管理；
	 * @param user_:删除目标表单管理对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removeForm(Form form_,boolean flag);
	
	/**
	 * 更新表单管理信息；
	 * @param user_：更新目标表单管理对象信息；
	 * @return : 被更新表单管理的总条数
	 */ 
	public  int  updateForm(Form form_);
	
	

	/**
	 * 查询表单管理列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<Form> getListPage(FormQuery formQuery);
	
	/**
	 * 查询数据库表列表
	 * @return
	 */
	public List<Map<String,String>> getTableList();
	
	/**
	 * 根据表名获取列定义信息
	 * @param tableName
	 * @return
	 */
	public List<TabColModel> getColList(String tableName);
}
