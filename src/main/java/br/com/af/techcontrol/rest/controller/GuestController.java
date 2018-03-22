package br.com.af.techcontrol.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.controller.base.AbstractController;
import br.com.af.techcontrol.rest.dto.UserInfo;
import br.com.af.techcontrol.rest.entity.base.User;
import br.com.af.techcontrol.rest.service.UserService;

@RestController
@RequestMapping("/guest")
public class GuestController extends AbstractController<User, Long> {

	@Autowired
	UserService userService;

	@Autowired
	public GuestController(UserService userService) {
		super(userService);
	}

	@GetMapping(value = "username/{username}")
	public ResponseEntity<UserInfo> retrieveUserInfo(@PathVariable String username) {

		UserInfo user = userService.findByUsernameProjection(username);

		if (user == null) {
			return new ResponseEntity<UserInfo>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<UserInfo>(user, new HttpHeaders(), HttpStatus.OK);
	}

}