package br.com.af.techcontrol.rest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.Contato;
import br.com.af.techcontrol.rest.repository.ContatoRepository;

@Service
@Transactional
public class ContatoService {

	@Autowired
	ContatoRepository contatoRepository;

	public Contato save(Contato contato) {
		return contatoRepository.save(contato);
	}
	
}
