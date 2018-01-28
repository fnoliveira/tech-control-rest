package br.com.af.techcontrol.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.dto.UserDto;
import br.com.af.techcontrol.rest.service.UserService;
import br.com.af.techcontrol.rest.util.CustomErrorType;

@RestController
@RequestMapping("/guest")
public class GuestController {

	@Autowired
	UserService userService;

	
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