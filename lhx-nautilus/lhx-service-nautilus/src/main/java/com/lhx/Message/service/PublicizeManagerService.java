package com.lhx.Message.service;

import java.util.List;
import com.lhx.message.publicize.model.Publicize;
import com.lhx.message.publicize.model.PublicizeQuery;

/**
 * 发布公告表管理相关服务接口
 * @author liangshu
 *
 */
public interface PublicizeManagerService {
	
	/**
	 * 添加新发布公告表；
	 * @param user：新增发布公告表目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addPublicize(Publicize publicize_);
	
	/**
	 * 删除发布公告表；
	 * @param user_:删除目标发布公告表对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removePublicize(Publicize publicize_,boolean flag);
	
	/**
	 * 更新发布公告表信息；
	 * @param user_：更新目标发布公告表对象信息；
	 * @return : 被更新发布公告表的总条数
	 */ 
	public  int  updatePublicize(Publicize publicize_);
	
	public List<Publicize> getList(Publicize publicize);

	/**
	 * 查询发布公告表列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<Publicize> getListPage(PublicizeQuery publicizeQuery);
	
	
	public Publicize get(String id_);
}
