package com.lhx.system.service;

import java.util.List;
import com.lhx.system.formType.model.FormType;
import com.lhx.system.formType.model.FormTypeQuery;

/**
 * 表单分类管理相关服务接口
 * @author liangshu
 *
 */
public interface FormTypeManagerService {
	
	/**
	 * 添加新表单分类；
	 * @param user：新增表单分类目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addFormType(FormType formType_);
	
	/**
	 * 删除表单分类；
	 * @param user_:删除目标表单分类对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removeFormType(FormType formType_,boolean flag);
	
	/**
	 * 更新表单分类信息；
	 * @param user_：更新目标表单分类对象信息；
	 * @return : 被更新表单分类的总条数
	 */ 
	public  int  updateFormType(FormType formType_);
	
	
	public List<FormType> getList(FormType formType_);

	/**
	 * 查询表单分类列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<FormType> getListPage(FormTypeQuery formTypeQuery);
	
	
	public FormType get(String id_);
}
