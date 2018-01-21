package br.com.af.techcontrol.rest.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {

	ROLE_ADMIN,
	
	ROLE_STANDARD,

	ROLE_TRUSTED_GUEST,
	
	ROLE_GUEST;

	@Override
	public String getAuthority() {
		return name();
	}
	
}
