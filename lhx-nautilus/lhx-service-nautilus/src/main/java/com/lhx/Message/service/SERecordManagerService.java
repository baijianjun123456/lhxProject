package com.lhx.Message.service;

import java.util.List;
import com.lhx.message.sendrecord.model.SERecord;
import com.lhx.message.sendrecord.model.SERecordQuery;

/**
 * 发送记录管理相关服务接口
 * @author liangshu
 *
 */
public interface SERecordManagerService {
	
	/**
	 * 添加新发送记录；
	 * @param user：新增发送记录目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addSERecord(SERecord sERecord_);
	
	/**
	 * 删除发送记录；
	 * @param user_:删除目标发送记录对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removeSERecord(SERecord sERecord_,boolean flag);
	
	/**
	 * 更新发送记录信息；
	 * @param user_：更新目标发送记录对象信息；
	 * @return : 被更新发送记录的总条数
	 */ 
	public  int  updateSERecord(SERecord sERecord_);
	
	public List<SERecord> getList(SERecord sERecord);

	/**
	 * 查询发送记录列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<SERecord> getListPage(SERecordQuery sERecordQuery);
	
	
	public SERecord get(String id_);
}
