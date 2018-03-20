package br.com.af.techcontrol.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.Contato;
import br.com.af.techcontrol.rest.repository.ContatoRepository;
import br.com.af.techcontrol.rest.service.base.AbstractService;

@Service
public class ContatoServiceImpl extends AbstractService<Contato, Long> implements ContatoService {

	@Autowired
	ContatoRepository contatoRepository;

}
