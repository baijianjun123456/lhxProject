package com.lhx.Message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhx.Message.service.SERecordManagerService;
import com.lhx.message.sendrecord.dao.SERecordDao;
import com.lhx.message.sendrecord.model.SERecord;
import com.lhx.message.sendrecord.model.SERecordQuery;
import com.lhx.system.service.constants.SystemConstants;

@Service
public class SERecordManagerServiceImpl implements SERecordManagerService {
	
    @Autowired
	private SERecordDao  sERecordDao;
    
	@Override
	public boolean addSERecord(SERecord sERecord_) {
		sERecordDao.save(sERecord_);
		return true;
	}

	@Override
	public boolean removeSERecord(SERecord sERecord_, boolean flag) {
		if(flag){
			sERecordDao.delete(sERecord_.getId_());
		}
		else{
			sERecord_.setStatus(SystemConstants.DELETE_STATE);
			sERecordDao.update(sERecord_);
		}
		return true;
	}

	@Override
	public int updateSERecord(SERecord sERecord_) {
		
		return sERecordDao.update(sERecord_);
	}
	
	public SERecord get(SERecord sERecord_){
		List<SERecord> sERecordList = sERecordDao.queryList(sERecord_);
		return (sERecordList == null || sERecordList.size() <= 0) ? null : sERecordList.get(0);
	}
	
	public List<SERecord> getList(SERecord sERecord_){
		return sERecordDao.queryList(sERecord_);
	}
	
	public List<SERecord> getListPage(SERecordQuery sERecordQuery){
		return sERecordDao.queryListPage(sERecordQuery);
	}
	
	public SERecord get(String id_){
		return sERecordDao.query(id_);
	}

}
