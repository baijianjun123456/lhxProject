package com.lhx.system.service;

import java.util.List;
import com.lhx.system.dict.model.Dict;
import com.lhx.system.dict.model.DictQuery;

/**
 * 数据字典管理相关服务接口
 * @author liangshu
 *
 */
public interface DictManagerService {
	
	/**
	 * 添加新数据字典；
	 * @param user：新增数据字典目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addDict(Dict dict_);
	
	/**
	 * 删除数据字典；
	 * @param user_:删除目标数据字典对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removeDict(Dict dict_,boolean flag);
	
	/**
	 * 更新数据字典信息；
	 * @param user_：更新目标数据字典对象信息；
	 * @return : 被更新数据字典的总条数
	 */ 
	public  int  updateDict(Dict dict_);
	
	public List<Dict> getList(Dict dict);

	/**
	 * 查询数据字典列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<Dict> getListPage(DictQuery dictQuery);
	
	
	public Dict get(String id_);
}
