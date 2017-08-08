package com.lhx.system.service;

import java.util.List;
import com.lhx.system.formDef.model.FormDef;
import com.lhx.system.formDef.model.FormDefQuery;

/**
 * 表单定义管理相关服务接口
 * @author liangshu
 *
 */
public interface FormDefManagerService {
	
	/**
	 * 添加新表单定义；
	 * @param user：新增表单定义目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addFormDef(FormDef formDef_);
	
	/**
	 * 删除表单定义；
	 * @param user_:删除目标表单定义对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removeFormDef(FormDef formDef_,boolean flag);
	
	/**
	 * 更新表单定义信息；
	 * @param user_：更新目标表单定义对象信息；
	 * @return : 被更新表单定义的总条数
	 */ 
	public  int  updateFormDef(FormDef formDef_);
	
	

	/**
	 * 查询表单定义列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<FormDef> getListPage(FormDefQuery formDefQuery);
	
	
	public FormDef get(String id_);
	
}
