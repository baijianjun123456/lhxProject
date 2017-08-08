package com.lhx.common.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.lhx.common.constants.MessageConstants;
import com.lhx.utils.StringUtil;

public class AuthenticationProvider extends DaoAuthenticationProvider {

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
		if (authentication.getCredentials() == null) {
			logger.debug("Authentication failed: no credentials provided");

			throw new BadCredentialsException(messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials",
					"Bad credentials"));
		}
		
		String presentedPassword = authentication.getCredentials().toString();

		if(StringUtil.getStr(userDetails.getPassword()).equals(presentedPassword)){
			return;
		}else{
			throw new BadCredentialsException(MessageConstants.LoginError.LOGIN_PASSWORD_ERROR);
		}

	}

}
