package br.com.af.techcontrol.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.base.Pessoa;
import br.com.af.techcontrol.rest.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	@Transactional(readOnly = true)
	public void createPessoaIfNotFound(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}
	
	@Transactional
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

}
