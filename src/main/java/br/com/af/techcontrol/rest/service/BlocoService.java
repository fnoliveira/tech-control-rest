package br.com.af.techcontrol.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.condominio.Bloco;
import br.com.af.techcontrol.rest.repository.BlocoRepository;

@Service
public class BlocoService {

	@Autowired
	BlocoRepository repository;

	@Transactional(readOnly = true)
	public List<Bloco> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Bloco save(Bloco bloco) {
		return repository.save(bloco);
	}

	@Transactional(readOnly = true)
	public Bloco findOne(Long id) {
		return repository.findOne(id);
	}

	@Transactional
	public void save(List<Bloco> blocos) {
		repository.save(blocos);
	}

}
