package br.com.af.techcontrol.rest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.Pessoa;
import br.com.af.techcontrol.rest.repository.PessoaRepository;

@Service
@Transactional
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;
	
	public void createPessoaIfNotFound(Pessoa pessoa) {
		
		pessoaRepository.save(pessoa);
		
	}

}
