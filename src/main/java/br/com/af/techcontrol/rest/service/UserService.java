package br.com.af.techcontrol.rest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.dto.UserDto;
import br.com.af.techcontrol.rest.entity.User;
import br.com.af.techcontrol.rest.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public synchronized boolean create(UserDto userDto) {
		
		if (userRepository.findOne(userDto.getUsername()) != null) {
			return false;
		} else {

			User user = new User();

			user.setName(userDto.getName());
			user.setUsername(userDto.getUsername());
			user.setEmail(userDto.getEmail());
			user.setPassword(passwordEncoder.encode(userDto.getPassword()));
			user.setRoles(userDto.getRoles());

			userRepository.save(user);
			
			return true;
		}
	}
	
	public UserDto findByUsername(String username) {
		
		User user = userRepository.findOne(username);
		
		UserDto userDto = new UserDto();
		userDto.setEmail(user.getEmail());
		userDto.setName(user.getName());
		userDto.setUsername(user.getUsername());
		
		return userDto;
	}
	
}