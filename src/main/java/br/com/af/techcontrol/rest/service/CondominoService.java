package br.com.af.techcontrol.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.condomino.Condomino;
import br.com.af.techcontrol.rest.repository.CondominoRepository;

@Service
public class CondominoService {

	@Autowired
	CondominoRepository condominoRepository;

	@Transactional
	public Condomino save(Condomino condomino) {
		return condominoRepository.save(condomino);
	}

	@Transactional(readOnly=true)
	public Condomino findByCNPJ(String cpf_cnpj) {
		return condominoRepository.findByPessoaCpfOuCnpj(cpf_cnpj);
	}
}
