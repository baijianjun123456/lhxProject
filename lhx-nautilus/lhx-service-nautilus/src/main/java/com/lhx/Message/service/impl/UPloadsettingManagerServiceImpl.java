package com.lhx.Message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhx.Message.service.UPloadsettingManagerService;
import com.lhx.message.uploadsetting.dao.UPloadsettingDao;
import com.lhx.message.uploadsetting.model.UPloadsetting;
import com.lhx.message.uploadsetting.model.UPloadsettingQuery;
import com.lhx.system.service.constants.SystemConstants;

@Service
public class UPloadsettingManagerServiceImpl implements UPloadsettingManagerService {
	
    @Autowired
	private UPloadsettingDao  uPloadsettingDao;
    
	@Override
	public boolean addUPloadsetting(UPloadsetting uPloadsetting_) {
		uPloadsettingDao.save(uPloadsetting_);
		return true;
	}

	@Override
	public boolean removeUPloadsetting(UPloadsetting uPloadsetting_, boolean flag) {
		if(flag){
			uPloadsettingDao.delete(uPloadsetting_.getId_());
		}
		else{
			uPloadsetting_.setStatus(SystemConstants.DELETE_STATE);
			uPloadsettingDao.update(uPloadsetting_);
		}
		return true;
	}

	@Override
	public int updateUPloadsetting(UPloadsetting uPloadsetting_) {
		
		return uPloadsettingDao.update(uPloadsetting_);
	}
	
	public UPloadsetting get(UPloadsetting uPloadsetting_){
		List<UPloadsetting> uPloadsettingList = uPloadsettingDao.queryList(uPloadsetting_);
		return (uPloadsettingList == null || uPloadsettingList.size() <= 0) ? null : uPloadsettingList.get(0);
	}
	
	public List<UPloadsetting> getList(UPloadsetting uPloadsetting_){
		return uPloadsettingDao.queryList(uPloadsetting_);
	}
	
	public List<UPloadsetting> getListPage(UPloadsettingQuery uPloadsettingQuery){
		return uPloadsettingDao.queryListPage(uPloadsettingQuery);
	}
	
	public UPloadsetting get(String id_){
		return uPloadsettingDao.query(id_);
	}

}
