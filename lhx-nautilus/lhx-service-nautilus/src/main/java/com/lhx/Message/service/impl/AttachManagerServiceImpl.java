package com.lhx.Message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhx.Message.service.AttachManagerService;
import com.lhx.message.attach.dao.AttachDao;
import com.lhx.message.attach.model.Attach;
import com.lhx.message.attach.model.AttachQuery;
import com.lhx.system.service.constants.SystemConstants;

@Service
public class AttachManagerServiceImpl implements AttachManagerService {
	
    @Autowired
	private AttachDao  attachDao;
    
	@Override
	public boolean addAttach(Attach attach_) {
		attachDao.save(attach_);
		return true;
	}

	@Override
	public boolean removeAttach(Attach attach_, boolean flag) {
		if(flag){
			attachDao.delete(attach_.getId_());
		}
		else{
			attach_.setStatus(SystemConstants.DELETE_STATE);
			attachDao.update(attach_);
		}
		return true;
	}

	@Override
	public int updateAttach(Attach attach_) {
		
		return attachDao.update(attach_);
	}
	
	public Attach get(Attach attach_){
		List<Attach> attachList = attachDao.queryList(attach_);
		return (attachList == null || attachList.size() <= 0) ? null : attachList.get(0);
	}
	
	public List<Attach> getList(Attach attach_){
		return attachDao.queryList(attach_);
	}
	
	public List<Attach> getListPage(AttachQuery attachQuery){
		return attachDao.queryListPage(attachQuery);
	}
	
	public Attach get(String id_){
		return attachDao.query(id_);
	}

}
