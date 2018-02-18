package br.com.af.techcontrol.rest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.Privilege;
import br.com.af.techcontrol.rest.repository.PrivilegeRepository;

@Service
public class PrivilegeService {

	@Autowired
	PrivilegeRepository repository;

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
