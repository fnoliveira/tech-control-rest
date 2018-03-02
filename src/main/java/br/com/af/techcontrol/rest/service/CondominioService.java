package br.com.af.techcontrol.rest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.condominio.Condominio;
import br.com.af.techcontrol.rest.repository.CondominioRepository;

@Service
@Transactional
public class CondominioService {

	@Autowired
	CondominioRepository condominioRepository;

	public void save(Condominio condominio) {
		condominioRepository.save(condominio);
	}

	public Condominio findByCNPJ(String cpf_cnpj) {
		return condominioRepository.findByPessoaCpfOuCnpj(cpf_cnpj);
	}
}
