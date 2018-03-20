package br.com.af.techcontrol.rest.service;

import br.com.af.techcontrol.rest.entity.base.Privilege;
import br.com.af.techcontrol.rest.service.base.CrudService;

public interface PrivilegeService extends CrudService<Privilege, Long>{

	Privilege createPrivilegeIfNotFound(String name);

}