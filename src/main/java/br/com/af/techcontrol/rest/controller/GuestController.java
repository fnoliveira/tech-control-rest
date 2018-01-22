package br.com.af.techcontrol.rest.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.af.techcontrol.rest.dto.UserDto;
import br.com.af.techcontrol.rest.entity.Role;
import br.com.af.techcontrol.rest.enums.Roles;
import br.com.af.techcontrol.rest.service.UserService;
import br.com.af.techcontrol.rest.util.CustomErrorType;

@RestController
@RequestMapping("/guest")
public class GuestController {

	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody UserDto user, UriComponentsBuilder builder) {

		Set<Role> roles = new HashSet<Role>();
		roles.add(new Role(1,Roles.ROLE_GUEST.getAuthority()));
		
		user.setRoles(roles);

		boolean flag = userService.create(user);

		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();

		headers.setLocation(builder.path("/guest?id={id}").buildAndExpand(user.getEmail()).toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{username}")
	public ResponseEntity<?> getUser(@PathVariable("username") String username) {

		UserDto user = userService.findByUsername(username);

		if (user == null) {
			return new ResponseEntity<Object>(new CustomErrorType("User with username " + username + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
	}

}