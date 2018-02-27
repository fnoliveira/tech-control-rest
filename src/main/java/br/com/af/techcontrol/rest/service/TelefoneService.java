package br.com.af.techcontrol.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.Telefone;
import br.com.af.techcontrol.rest.repository.TelefoneRepository;

@Service
@Transactional
public class TelefoneService {

	@Autowired
	TelefoneRepository repository;

	public List<Telefone> findAll() {
		return repository.findAll();
	}

	public Telefone save(Telefone telefone) {
		return repository.save(telefone);
	}

	public Telefone findOne(Long id) {
		return repository.findOne(id);
	}

	public void delete(Long id) {
		repository.delete(id);
	}
	
}
