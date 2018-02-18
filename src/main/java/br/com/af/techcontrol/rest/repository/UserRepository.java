package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.entity.base.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	
	User findByPessoaIdAndUsername(Long pessoaId, String username);
	
}
