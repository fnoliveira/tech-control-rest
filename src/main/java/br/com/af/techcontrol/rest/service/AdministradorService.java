package br.com.af.techcontrol.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.condominio.Administrador;
import br.com.af.techcontrol.rest.repository.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
	AdministradorRepository repository;

	public List<Administrador> findAll() {
		return repository.findAll();
	}

	public Administrador save(Administrador administrador) {
		return repository.save(administrador);
	}

	public Administrador findOne(Long administradorId) {
		return repository.findOne(administradorId);
	}

	public void delete(Long id) {
		repository.delete(id);
	}
}
