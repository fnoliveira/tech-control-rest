package br.com.af.techcontrol.rest.service;

import java.util.Collection;

import br.com.af.techcontrol.rest.entity.base.Privilege;
import br.com.af.techcontrol.rest.entity.base.Role;
import br.com.af.techcontrol.rest.service.base.CrudService;

public interface RoleService extends CrudService<Role, Long>{

	Role findByName(String name);

	Role createRoleIfNotFound(String name, Collection<Privilege> privileges);

}