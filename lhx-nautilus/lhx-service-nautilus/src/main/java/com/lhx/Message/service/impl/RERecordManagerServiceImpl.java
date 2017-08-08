package com.lhx.Message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhx.Message.service.RERecordManagerService;
import com.lhx.message.receiverecord.dao.RERecordDao;
import com.lhx.message.receiverecord.model.RERecord;
import com.lhx.message.receiverecord.model.RERecordQuery;
import com.lhx.system.service.constants.SystemConstants;

@Service
public class RERecordManagerServiceImpl implements RERecordManagerService {
	
    @Autowired
	private RERecordDao  rERecordDao;
    
	@Override
	public boolean addRERecord(RERecord rERecord_) {
		rERecordDao.save(rERecord_);
		return true;
	}

	@Override
	public boolean removeRERecord(RERecord rERecord_, boolean flag) {
		if(flag){
			rERecordDao.delete(rERecord_.getId_());
		}
		else{
			rERecord_.setStatus(SystemConstants.DELETE_STATE);
			rERecordDao.update(rERecord_);
		}
		return true;
	}

	@Override
	public int updateRERecord(RERecord rERecord_) {
		
		return rERecordDao.update(rERecord_);
	}
	@Override
	public RERecord get(RERecord rERecord_){
		List<RERecord> rERecordList = rERecordDao.queryList(rERecord_);
		return (rERecordList == null || rERecordList.size() <= 0) ? null : rERecordList.get(0);
	}
	
	public List<RERecord> getList(RERecord rERecord_){
		return rERecordDao.queryList(rERecord_);
	}
	
	public List<RERecord> getListPage(RERecordQuery rERecordQuery){
		return rERecordDao.queryListPage(rERecordQuery);
	}
	
	public RERecord get(String id_){
		return rERecordDao.query(id_);
	}

}
