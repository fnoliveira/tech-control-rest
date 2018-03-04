package br.com.af.techcontrol.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.condominio.Unidade;
import br.com.af.techcontrol.rest.repository.UnidadeRepository;

@Service
public class UnidadeService {

	@Autowired
	UnidadeRepository repository;

	@Transactional(readOnly = true)
	public List<Unidade> findAll() {
		return repository.findAll();
	}

	@Transactional
	public List<Unidade> saveAll(List<Unidade> unidades) {
		return repository.save(unidades);
	}

	@Transactional
	public Unidade save(Unidade unidades) {
		return repository.save(unidades);
	}

	@Transactional
	public List<Unidade> save(List<Unidade> unidades) {
		return repository.save(unidades);
	}

	@Transactional(readOnly = true)
	public Unidade findOne(Long id) {
		return repository.findOne(id);
	}

}
