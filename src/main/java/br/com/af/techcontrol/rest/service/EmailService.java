package br.com.af.techcontrol.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.Contato;
import br.com.af.techcontrol.rest.entity.base.Email;
import br.com.af.techcontrol.rest.repository.EmailRepository;

@Service
public class EmailService {

	@Autowired
	EmailRepository repository;

	public List<Email> findAll() {
		return repository.findAll();
	}

	public Email save(Email email) {
		return repository.save(email);
	}

	public Email findOne(Long emailId) {
		return repository.findOne(emailId);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

	public Email createEmailIfNotFound(String tipo, String endereco, Boolean isPrincipal, Contato contato) {

		Email email = repository.findByContatoIdAndEndereco(contato.getId(), endereco);

		if (email == null) {
			email = new Email(tipo, endereco, isPrincipal, true, contato);
			return repository.save(email);
		}

		return email;

	}
}
