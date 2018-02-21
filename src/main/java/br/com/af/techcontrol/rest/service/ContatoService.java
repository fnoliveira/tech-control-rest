package br.com.af.techcontrol.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.Contato;
import br.com.af.techcontrol.rest.entity.base.Email;
import br.com.af.techcontrol.rest.entity.base.Pessoa;
import br.com.af.techcontrol.rest.entity.base.Telefone;
import br.com.af.techcontrol.rest.repository.ContatoRepository;

@Service
@Transactional
public class ContatoService {

	@Autowired
	ContatoRepository repository;

	@Autowired
	TelefoneService telefoneService;

	@Autowired
	EmailService emailService;

	public Contato save(Contato contato) {
		return repository.save(contato);
	}

	public List<Contato> findAll() {
		return repository.findAll();
	}

	public Contato findOne(Long id) {
		return repository.findOne(id);
	}

	public void delete(Long id) {
		repository.delete(id);
	}


}
