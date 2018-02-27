package br.com.af.techcontrol.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.dto.UserInfo;
import br.com.af.techcontrol.rest.response.ApiStatusResponse;
import br.com.af.techcontrol.rest.response.Response;
import br.com.af.techcontrol.rest.service.UserService;

@RestController
@RequestMapping("/guest")
public class GuestController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/{username}")
	public ResponseEntity<Response<UserInfo>> retrieveUserInfo(@PathVariable("username") String username) {

		UserInfo user = userService.findByUsernameProjection(username);

		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<UserInfo>(
					new ApiStatusResponse(HttpStatus.NOT_FOUND.value(), 4041, "User with username " + username + " not found")));
		}

		return ResponseEntity.ok(new Response<UserInfo>(user, new ApiStatusResponse(HttpStatus.OK.value(), 2001,"Sucesso")));
	}

}