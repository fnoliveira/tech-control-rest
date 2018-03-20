package br.com.af.techcontrol.rest.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.base.Privilege;
import br.com.af.techcontrol.rest.entity.base.Role;
import br.com.af.techcontrol.rest.repository.RoleRepository;
import br.com.af.techcontrol.rest.service.base.AbstractService;

@Service
public class RoleServiceImpl extends AbstractService<Role, Long> implements RoleService {

	@Autowired
	RoleRepository repository;

	@Transactional(readOnly = true)
	public Role findByName(String name) {
		return repository.findByName(name);
	}

	@Transactional
	public Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {

		Role role = findByName(name);

		if (role == null) {
			role = new Role(name);
			role.setPrivileges(privileges);
			return repository.save(role);
		}

		return role;
	}
}
