package br.com.af.techcontrol.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.base.Contato;
import br.com.af.techcontrol.rest.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	ContatoRepository contatoRepository;

	@Transactional
	public Contato save(Contato contato) {
		return contatoRepository.save(contato);
	}
	
}
