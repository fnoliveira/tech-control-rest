package br.com.af.techcontrol.rest.dto;

import java.util.Set;

import br.com.af.techcontrol.rest.model.Role;
import lombok.Data;

@Data
public class UserDto {

	private String name;
	
	private String username;
	
	private String email;
	
	private String password;

	private Set<Role> roles;
	
}