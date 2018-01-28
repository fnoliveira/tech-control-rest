package br.com.af.techcontrol.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.condominio.Administrador;
import br.com.af.techcontrol.rest.repository.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
	AdministradorRepository administracaoRepository;

	public List<Administrador> findAll() {
		return administracaoRepository.findAll();
	}

	public Administrador save(Administrador administracao) {
		return administracaoRepository.save(administracao);
	}
}
