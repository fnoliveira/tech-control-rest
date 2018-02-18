package br.com.af.techcontrol.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.Contato;
import br.com.af.techcontrol.rest.entity.base.Telefone;
import br.com.af.techcontrol.rest.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	TelefoneRepository repository;

	public List<Telefone> findAll() {
		return repository.findAll();
	}

	public Telefone save(Telefone telefone) {
		return repository.save(telefone);
	}

	public Telefone findOne(Long telefoneId) {
		return repository.findOne(telefoneId);
	}

	public void delete(Long id) {
		repository.delete(id);
	}
	
	public Telefone createTelefoneIfNotFound(String tipo, String ddd, String numero, Contato contato ) {
		
		Telefone telefone = repository.findByContatoIdAndDddAndNumero(contato.getId(), ddd, numero);
		
		if (telefone == null) {
			telefone = new Telefone(tipo, ddd, numero, contato, true);
			return repository.save(telefone);
		}
		
		return telefone;
		
	}
}
