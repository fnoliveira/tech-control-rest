package br.com.af.techcontrol.rest.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.base.Telefone;
import br.com.af.techcontrol.rest.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	TelefoneRepository repository;

	@Transactional(readOnly=true)
	public List<Telefone> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Telefone save(Telefone telefone) {
		return repository.save(telefone);
	}

	@Transactional(readOnly=true)
	public Telefone findOne(Long id) {
		return repository.findOne(id);
	}

}
