package com.lhx.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lhx.system.service.constants.SystemConstants;
import com.lhx.system.service.ResourceManagerService;
import com.lhx.system.resource.dao.ResourceDao;
import com.lhx.system.resource.model.Resource;
import com.lhx.system.resource.model.ResourceQuery;

@Service
public class ResourceManagerServiceImpl implements ResourceManagerService {
	
    @Autowired
	private ResourceDao  resourceDao;
    
	@Override
	public boolean addResource(Resource resource_) {
		resourceDao.save(resource_);
		return true;
	}

	@Override
	public boolean removeResource(Resource resource_, boolean flag) {
		if(flag){
			resourceDao.delete(resource_.getId_());
		}
		else{
			resource_.setStatus(SystemConstants.DELETE_STATE);
			resourceDao.update(resource_);
		}
		return true;
	}

	@Override
	public int updateResource(Resource resource_) {
		
		return resourceDao.update(resource_);
	}
	
	public Resource get(Resource resource_){
		List<Resource> resourceList = resourceDao.queryList(resource_);
		return (resourceList == null || resourceList.size() <= 0) ? null : resourceList.get(0);
	}
	
	public List<Resource> getList(Resource resource_){
		return resourceDao.queryList(resource_);
	}
	
	public List<Resource> getListPage(ResourceQuery resourceQuery){
		return resourceDao.queryListPage(resourceQuery);
	}
	
	public Resource get(String id_){
		return resourceDao.query(id_);
	}

}
