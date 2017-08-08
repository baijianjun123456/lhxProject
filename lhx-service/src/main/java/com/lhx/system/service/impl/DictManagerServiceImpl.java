package com.lhx.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lhx.system.service.constants.SystemConstants;
import com.lhx.system.service.DictManagerService;
import com.lhx.system.dict.dao.DictDao;
import com.lhx.system.dict.model.Dict;
import com.lhx.system.dict.model.DictQuery;

@Service
public class DictManagerServiceImpl implements DictManagerService {
	
    @Autowired
	private DictDao  dictDao;
    
	@Override
	public boolean addDict(Dict dict_) {
		dictDao.save(dict_);
		return true;
	}

	@Override
	public boolean removeDict(Dict dict_, boolean flag) {
		if(flag){
			dictDao.delete(dict_.getId_());
		}
		else{
			dict_.setStatus(SystemConstants.DELETE_STATE);
			dictDao.update(dict_);
		}
		return true;
	}

	@Override
	public int updateDict(Dict dict_) {
		
		return dictDao.update(dict_);
	}
	
	public Dict get(Dict dict_){
		List<Dict> dictList = dictDao.queryList(dict_);
		return (dictList == null || dictList.size() <= 0) ? null : dictList.get(0);
	}
	
	public List<Dict> getList(Dict dict_){
		return dictDao.queryList(dict_);
	}
	
	public List<Dict> getListPage(DictQuery dictQuery){
		return dictDao.queryListPage(dictQuery);
	}
	
	public Dict get(String id_){
		return dictDao.query(id_);
	}

}
