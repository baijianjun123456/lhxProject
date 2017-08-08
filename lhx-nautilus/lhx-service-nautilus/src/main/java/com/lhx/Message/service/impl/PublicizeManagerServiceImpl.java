package com.lhx.Message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhx.Message.service.PublicizeManagerService;
import com.lhx.message.publicize.dao.PublicizeDao;
import com.lhx.message.publicize.model.Publicize;
import com.lhx.message.publicize.model.PublicizeQuery;
import com.lhx.system.service.constants.SystemConstants;

@Service
public class PublicizeManagerServiceImpl implements PublicizeManagerService {
	
    @Autowired
	private PublicizeDao  publicizeDao;
    
	@Override
	public boolean addPublicize(Publicize publicize_) {
		publicizeDao.save(publicize_);
		return true;
	}

	@Override
	public boolean removePublicize(Publicize publicize_, boolean flag) {
		if(flag){
			publicizeDao.delete(publicize_.getId_());
		}
		else{
			publicize_.setIsdel(SystemConstants.DELETE_STATE);
			publicizeDao.update(publicize_);
		}
		return true;
	}

	@Override
	public int updatePublicize(Publicize publicize_) {
		
		return publicizeDao.update(publicize_);
	}
	
	public Publicize get(Publicize publicize_){
		List<Publicize> publicizeList = publicizeDao.queryList(publicize_);
		return (publicizeList == null || publicizeList.size() <= 0) ? null : publicizeList.get(0);
	}
	
	public List<Publicize> getList(Publicize publicize_){
		return publicizeDao.queryList(publicize_);
	}
	
	public List<Publicize> getListPage(PublicizeQuery publicizeQuery){
		return publicizeDao.queryListPage(publicizeQuery);
	}
	
	public Publicize get(String id_){
		return publicizeDao.query(id_);
	}

}
