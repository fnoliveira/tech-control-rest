package br.com.af.techcontrol.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.Endereco;
import br.com.af.techcontrol.rest.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository repository;

	public Endereco save(Endereco endereco) {
		return repository.save(endereco);
	}

	public List<Endereco> findAll() {
		return repository.findAll();
	}

	public Endereco findById(Long enderecoId) {
		return repository.findOne(enderecoId);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

	public Endereco createEndereco(String cep, String logradouro, String numero, String complemento, String bairro,
			String cidade, String uf) {
		
		Endereco endereco = new Endereco(cep, logradouro, numero, complemento, bairro, cidade, uf, "BR", true);
		return save(endereco);
	}
}
