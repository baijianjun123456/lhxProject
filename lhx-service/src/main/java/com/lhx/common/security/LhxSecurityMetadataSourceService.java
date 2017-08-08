package com.lhx.common.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.CollectionUtils;
import com.lhx.system.resource.dao.ResourceDao;

public class LhxSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

	
	@Autowired
	private ResourceDao  resourceDao;
	
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return new ArrayList<ConfigAttribute>();  
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object filter) throws IllegalArgumentException {
		
		String url = ((FilterInvocation)filter).getRequestUrl();  
		
		List<String> roleList = resourceDao.queryRolesByUrl(url);
		
	     Collection<ConfigAttribute> cfgAttr = null; 

	     
		if(CollectionUtils.isEmpty(roleList)){
	         cfgAttr = new ArrayList<ConfigAttribute>();  

			for(String roleId : roleList){
				cfgAttr.add(new SecurityConfig(roleId));  
			}
		}
		else{
			throw new IllegalArgumentException();
		}
		
		return cfgAttr;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
