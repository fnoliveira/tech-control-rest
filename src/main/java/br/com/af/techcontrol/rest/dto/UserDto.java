package br.com.af.techcontrol.rest.dto;

import java.util.Collection;

import br.com.af.techcontrol.rest.entity.base.Role;
import lombok.Data;

@Data
public class UserDto {

	private String name;
	
	private String username;
	
	private String email;
	
	private String password;

	private Collection<Role> roles;
	
}