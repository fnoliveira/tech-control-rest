package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.af.techcontrol.rest.dto.UserInfo;
import br.com.af.techcontrol.rest.entity.base.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u.pessoa.id as pessoaId, u.pessoa.nome as nome, u.id as userId, u.username as username, u.isEnable as isEnable FROM User u WHERE u.username = :username")
	UserInfo findByUsernameProjection(@Param("username")String username);
	
	User findByUsername(String username);
	
}
