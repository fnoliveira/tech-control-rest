package br.com.af.techcontrol.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.funcionario.Administrador;
import br.com.af.techcontrol.rest.repository.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
	AdministradorRepository administradorRepository;

	@Transactional
	public void save(Administrador administrador) {
		administradorRepository.save(administrador);
	}

	@Transactional(readOnly = true)
	public Administrador findByCPFCNPJ(String cpfOuCnpj) {
		return administradorRepository.findByFuncionarioPessoaCpfOuCnpj(cpfOuCnpj);
	}

	@Transactional(readOnly = true)
	public List<Administrador> findByName(String nome) {
		return administradorRepository.findByFuncionarioPessoaNome(nome);
	}

}
