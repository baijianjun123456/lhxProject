package com.lhx.Message.service;

import java.util.List;
import com.lhx.message.uploadsetting.model.UPloadsetting;
import com.lhx.message.uploadsetting.model.UPloadsettingQuery;

/**
 * 上传设置表管理相关服务接口
 * @author liangshu
 *
 */
public interface UPloadsettingManagerService {
	
	/**
	 * 添加新上传设置表；
	 * @param user：新增上传设置表目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addUPloadsetting(UPloadsetting uPloadsetting_);
	
	/**
	 * 删除上传设置表；
	 * @param user_:删除目标上传设置表对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removeUPloadsetting(UPloadsetting uPloadsetting_,boolean flag);
	
	/**
	 * 更新上传设置表信息；
	 * @param user_：更新目标上传设置表对象信息；
	 * @return : 被更新上传设置表的总条数
	 */ 
	public  int  updateUPloadsetting(UPloadsetting uPloadsetting_);
	
	public List<UPloadsetting> getList(UPloadsetting uPloadsetting);

	/**
	 * 查询上传设置表列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<UPloadsetting> getListPage(UPloadsettingQuery uPloadsettingQuery);
	
	
	public UPloadsetting get(String id_);
}
