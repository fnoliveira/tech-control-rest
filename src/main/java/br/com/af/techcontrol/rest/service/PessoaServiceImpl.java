package br.com.af.techcontrol.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.Pessoa;
import br.com.af.techcontrol.rest.repository.PessoaRepository;
import br.com.af.techcontrol.rest.service.base.AbstractService;

@Service
public class PessoaServiceImpl extends AbstractService<Pessoa, Long> implements PessoaService{

	@Autowired
	PessoaRepository pessoaRepository;

}
