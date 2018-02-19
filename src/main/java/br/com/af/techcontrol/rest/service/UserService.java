package br.com.af.techcontrol.rest.service;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.dto.UserDto;
import br.com.af.techcontrol.rest.entity.base.Pessoa;
import br.com.af.techcontrol.rest.entity.base.Role;
import br.com.af.techcontrol.rest.entity.base.User;
import br.com.af.techcontrol.rest.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleService roleService;

	public UserDto findByUsername(String username) {

		User user = repository.findByUsername(username);

		UserDto userDto = new UserDto();

		userDto.setName(user.getPessoa().getNome());
		userDto.setUsername(user.getUsername());

		return userDto;
	}

	public User save(User user) {
		return repository.save(user);
	}

	public User findByPessoaIdAndUsername(Long id, String username) {
		return repository.findByPessoaIdAndUsername(id, username);
	}
	
	public void createUserIfNotFound(Pessoa pessoa, String username, String password, String roleName) {

		Role role = roleService.findByName(roleName);
		
		User user = findByPessoaIdAndUsername(pessoa.getId(), username);
		
		if (user == null) {
			user = new User(username, passwordEncoder.encode("123456"), pessoa, Arrays.asList(role), true);
			save(user);
		}
		
	}

}