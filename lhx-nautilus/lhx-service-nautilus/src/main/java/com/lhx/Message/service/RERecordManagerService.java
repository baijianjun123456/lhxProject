package com.lhx.Message.service;

import java.util.List;

import com.lhx.message.receiverecord.model.RERecord;
import com.lhx.message.receiverecord.model.RERecordQuery;

/**
 * 接收记录管理相关服务接口
 * @author liangshu
 *
 */
public interface RERecordManagerService {
	
	/**
	 * 添加新接收记录；
	 * @param user：新增接收记录目标对象；
	 * @return：是否新增成功；
	 */
	public boolean addRERecord(RERecord rERecord_);
	
	/**
	 * 删除接收记录；
	 * @param user_:删除目标接收记录对象信息；
	 * @param flag：false:逻辑删除；true：物理删除;
	 * @return
	 */
	public boolean  removeRERecord(RERecord rERecord_,boolean flag);
	
	/**
	 * 更新接收记录信息；
	 * @param user_：更新目标接收记录对象信息；
	 * @return : 被更新接收记录的总条数
	 */ 
	public  int  updateRERecord(RERecord rERecord_);
	
	public List<RERecord> getList(RERecord rERecord);

	/**
	 * 查询接收记录列表-分页
	 * @param userQuery
	 * @return
	 */
	public List<RERecord> getListPage(RERecordQuery rERecordQuery);
	
	
	public RERecord get(String id_);
	/**
	 * 
	 * @param rERecord_
	 * @return
	 */
	public RERecord get(RERecord rERecord_);
}
