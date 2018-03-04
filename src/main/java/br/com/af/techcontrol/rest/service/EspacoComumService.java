package br.com.af.techcontrol.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.condominio.Bloco;
import br.com.af.techcontrol.rest.entity.condominio.EspacoComum;
import br.com.af.techcontrol.rest.repository.EspacoComumRepository;

@Service
@Transactional
public class EspacoComumService {

	@Autowired
	EspacoComumRepository repository;

	public List<EspacoComum> findAll() {
		return repository.findAll();
	}

	public EspacoComum save(EspacoComum espacoComum) {
		return repository.save(espacoComum);
	}
	
	public EspacoComum findByNome(String nome) {
		return repository.findByNome(nome);
	}

	public EspacoComum findOne(Long id) {
		return repository.findOne(id);
	}
	
	public void delete(Long id) {
		repository.delete(id);
	}

	public void save(List<EspacoComum> espacosComum) {
		repository.save(espacosComum);
	}

}
