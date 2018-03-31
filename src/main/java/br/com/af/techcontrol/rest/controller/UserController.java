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
import br.com.af.techcontrol.rest.entity.base.User;
import br.com.af.techcontrol.rest.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<User, Long> {

	@Autowired
	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super(userService);
	}

	@GetMapping("/details/{username}")
	public ResponseEntity<User> get(@PathVariable String username) {
		User entity = null;
		entity = userService.findByUsername(username);
		if (entity == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
	}
}