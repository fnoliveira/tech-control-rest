package br.com.af.techcontrol.rest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.dto.UserDto;
import br.com.af.techcontrol.rest.entity.base.User;
import br.com.af.techcontrol.rest.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;

	public UserDto findByUsername(String username) {

		User user = userRepository.findByUsername(username);

		UserDto userDto = new UserDto();

		userDto.setName(user.getPessoa().getNome());
		userDto.setUsername(user.getUsername());
		
		return userDto;
	}

}