package com.lhx.system.service;

import java.util.List;
import com.lhx.system.resource.model.Resource;
import com.lhx.system.resource.model.ResourceQuery;

/**
 * 系统资源访问表管理相关服务接口
 * @author liangshu
 *
 */
public interface ResourceManagerService {
	
	/**
	 * 添加新系统资源访问表；
	 * @param user：新增系统资源访问表目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addResource(Resource resource_);
	
	/**
	 * 删除系统资源访问表；
	 * @param user_:删除目标系统资源访问表对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removeResource(Resource resource_,boolean flag);
	
	/**
	 * 更新系统资源访问表信息；
	 * @param user_：更新目标系统资源访问表对象信息；
	 * @return : 被更新系统资源访问表的总条数
	 */ 
	public  int  updateResource(Resource resource_);
	
	public List<Resource> getList(Resource resource);

	/**
	 * 查询系统资源访问表列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<Resource> getListPage(ResourceQuery resourceQuery);
	
	
	public Resource get(String id_);
}
