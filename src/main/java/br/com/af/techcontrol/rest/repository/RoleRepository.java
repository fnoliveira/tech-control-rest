package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.entity.base.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByName(String name);
}
