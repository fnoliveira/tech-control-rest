package br.com.af.techcontrol.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.condominio.Unidade;
import br.com.af.techcontrol.rest.repository.UnidadeRepository;

@Service
@Transactional
public class UnidadeService {

	@Autowired
	UnidadeRepository repository;

	public List<Unidade> findAll() {
		return repository.findAll();
	}

	public List<Unidade> saveAll(List<Unidade> unidades) {
		return repository.save(unidades);
	}

	public Unidade save(Unidade unidades) {
		return repository.save(unidades);
	}

	public List<Unidade> save(List<Unidade> unidades) {
		return repository.save(unidades);
	}

	public Unidade findOne(Long id) {
		return repository.findOne(id);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

}
