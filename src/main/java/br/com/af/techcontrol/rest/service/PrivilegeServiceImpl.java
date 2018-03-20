package br.com.af.techcontrol.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.base.Privilege;
import br.com.af.techcontrol.rest.repository.PrivilegeRepository;
import br.com.af.techcontrol.rest.service.base.AbstractService;

@Service
public class PrivilegeServiceImpl extends AbstractService<Privilege, Long> implements PrivilegeService{

	@Autowired
	PrivilegeRepository repository;

	@Override
	@Transactional
	public Privilege createPrivilegeIfNotFound(String name) {

		Privilege privilege = repository.findByName(name);

		if (privilege == null) {
			privilege = new Privilege(name);
			return repository.save(privilege);
		}

		return privilege;
	}
}
