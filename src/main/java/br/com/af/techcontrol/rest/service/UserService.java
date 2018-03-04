package br.com.af.techcontrol.rest.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.dto.UserInfo;
import br.com.af.techcontrol.rest.entity.base.Role;
import br.com.af.techcontrol.rest.entity.base.User;
import br.com.af.techcontrol.rest.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	@Autowired
	private RoleService roleService;

	@Transactional(readOnly = true)
	public UserInfo findByUsernameProjection(String username) {
		return repository.findByUsernameProjection(username);
	}

	@Transactional(readOnly = true)
	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Transactional
	public User save(User user) {
		return repository.save(user);
	}

	@Transactional
	public void createUserIfNotFound(User user, String roleName) {

		User _user = findByUsername(user.getUsername());

		Role role = roleService.findByName(roleName);

		if (_user == null) {

			user.setRoles(Arrays.asList(role));

			save(user);
		}

	}

}