package com.lhx.common.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class LhxAccessDecisionManager implements AccessDecisionManager{
	
	private boolean isAllowIfAllAbstainDecisions = false;

	@Override
	public void decide(Authentication authentication, Object obj,Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
		if(configAttributes == null){
			return;
		}
		
		Iterator<ConfigAttribute> ite=configAttributes.iterator();
		while(ite.hasNext()){
			ConfigAttribute ca=ite.next();
			String needRole=ca.getAttribute();
			for(GrantedAuthority ga:authentication.getAuthorities()){
				if(needRole.equals(ga.getAuthority())){  
					return;
				}
			}
		}
		
		checkAllowIfAllAbstainDecisions();

	}
	
	 protected final void checkAllowIfAllAbstainDecisions() {
	      if (!this.isAllowIfAllAbstainDecisions()) {
	           throw new AccessDeniedException("Access is denied");
	      }
	 }
	    

	@Override
	public boolean supports(ConfigAttribute configattribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> class1) {
		return true;
	}
	
	public boolean isAllowIfAllAbstainDecisions() {
		return isAllowIfAllAbstainDecisions;
	}

	public void setAllowIfAllAbstainDecisions(boolean isAllowIfAllAbstainDecisions) {
		this.isAllowIfAllAbstainDecisions = isAllowIfAllAbstainDecisions;
	}

}
