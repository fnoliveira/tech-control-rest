package br.com.af.techcontrol.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.condominio.Bloco;
import br.com.af.techcontrol.rest.repository.BlocoRepository;

@Service
@Transactional
public class BlocoService {

	@Autowired
	BlocoRepository repository;

	public List<Bloco> findAll() {
		return repository.findAll();
	}

	public Bloco save(Bloco bloco) {
		return repository.save(bloco);
	}

	public Bloco findOne(Long id) {
		return repository.findOne(id);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

	public void save(List<Bloco> blocos) {
		repository.save(blocos);
	}

}
