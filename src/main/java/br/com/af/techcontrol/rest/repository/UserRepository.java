package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByUsername(String username);
	
}
