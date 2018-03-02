package br.com.af.techcontrol.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.dto.AdministradorInfo;
import br.com.af.techcontrol.rest.entity.funcionario.Administrador;
import br.com.af.techcontrol.rest.repository.AdministradorRepository;

@Service
@Transactional
public class AdministradorService {

	@Autowired
	AdministradorRepository administradorRepository;

	public void save(Administrador administrador) {
		administradorRepository.save(administrador);
	}

	public List<AdministradorInfo> findByNameProjection(String nome) {
		return administradorRepository.findByFuncionarioPessoaNome(nome);
	}

}
