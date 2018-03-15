package br.com.af.techcontrol.rest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.condominio.Avisos;
import br.com.af.techcontrol.rest.repository.AvisosRepository;

@Service
public class AvisosService {
	
	@Autowired
	AvisosRepository repository;
	
	@Transactional(readOnly = true)
	public List<Avisos> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Avisos save(Avisos avisos) {
		return repository.save(avisos);
	}

	@Transactional(readOnly = true)
	public Avisos findOne(Long id) {
		return repository.findOne(id);
	}

	@Transactional
	public void save(List<Avisos> avisos) {
		repository.save(avisos);
	}
	
	@Transactional
	public List<Avisos> findByCondominioId(Long condominioId){
		return repository.findByCondominioId(condominioId);
	}
	
	@Transactional
	public List<Avisos> findByIsFixo(Boolean isFixo, Long condominioId){
		return repository.findByIsFixo(isFixo, condominioId);
	}
	
	@Transactional
	public List<Avisos> findByStartAndEnd(LocalDateTime now, Long condominioId){
		return repository.findByStartAndEnd(now, condominioId);
	}	

}
