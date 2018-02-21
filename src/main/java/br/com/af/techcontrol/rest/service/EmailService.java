package br.com.af.techcontrol.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.Contato;
import br.com.af.techcontrol.rest.entity.base.Email;
import br.com.af.techcontrol.rest.repository.EmailRepository;

@Service
@Transactional
public class EmailService {

	@Autowired
	EmailRepository repository;

	public List<Email> findAll() {
		return repository.findAll();
	}

	public Email save(Email email) {
		return repository.save(email);
	}

	public Email findOne(Long id) {
		return repository.findOne(id);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

}
