package br.com.af.techcontrol.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.condominio.Condominio;
import br.com.af.techcontrol.rest.repository.CondominioRepository;

@Service
public class CondominioService {

	@Autowired
	CondominioRepository condominioRepository;

	@Transactional
	public Condominio save(Condominio condominio) {
		return condominioRepository.save(condominio);
	}

	@Transactional(readOnly=true)
	public Condominio findByCNPJ(String cpf_cnpj) {
		return condominioRepository.findByPessoaCpfOuCnpj(cpf_cnpj);
	}
}
