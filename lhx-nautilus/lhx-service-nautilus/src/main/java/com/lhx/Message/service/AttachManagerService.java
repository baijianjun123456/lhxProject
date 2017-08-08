package com.lhx.Message.service;

import java.util.List;
import com.lhx.message.attach.model.Attach;
import com.lhx.message.attach.model.AttachQuery;

/**
 * 附件表管理相关服务接口
 * @author liangshu
 *
 */
public interface AttachManagerService {
	
	/**
	 * 添加新附件表；
	 * @param user：新增附件表目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addAttach(Attach attach_);
	
	/**
	 * 删除附件表；
	 * @param user_:删除目标附件表对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removeAttach(Attach attach_,boolean flag);
	
	/**
	 * 更新附件表信息；
	 * @param user_：更新目标附件表对象信息；
	 * @return : 被更新附件表的总条数
	 */ 
	public  int  updateAttach(Attach attach_);
	
	public List<Attach> getList(Attach attach);

	/**
	 * 查询附件表列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<Attach> getListPage(AttachQuery attachQuery);
	
	
	public Attach get(String id_);
}
