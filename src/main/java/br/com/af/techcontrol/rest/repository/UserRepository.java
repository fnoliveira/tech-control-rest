package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.model.User;

public interface UserRepository extends JpaRepository<User, String>{

}
