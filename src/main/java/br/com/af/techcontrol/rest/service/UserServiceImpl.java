package br.com.af.techcontrol.rest.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.dto.UserInfo;
import br.com.af.techcontrol.rest.entity.base.Role;
import br.com.af.techcontrol.rest.entity.base.User;
import br.com.af.techcontrol.rest.repository.UserRepository;
import br.com.af.techcontrol.rest.service.base.AbstractService;

@Service
public class UserServiceImpl extends AbstractService<User, Long> implements UserService {

	@Autowired
	UserRepository repository;

	@Autowired
	private RoleService roleService;

	@Override
	@Transactional(readOnly = true)
	public UserInfo findByUsernameProjection(String username) {
		return repository.findByUsernameProjection(username);
	}

	@Override
	@Transactional(readOnly = true)
	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}
	
	@Override
	@Transactional
	public void createUserIfNotFound(User user, String roleName) {

		User _user = findByUsername(user.getUsername());

		Role role = roleService.findByName(roleName);

		if (_user == null) {

			user.setRoles(Arrays.asList(role));

			salvar(user);
		}
	}

}