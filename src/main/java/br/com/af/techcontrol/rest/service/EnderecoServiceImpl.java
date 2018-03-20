package br.com.af.techcontrol.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.Endereco;
import br.com.af.techcontrol.rest.repository.EnderecoRepository;
import br.com.af.techcontrol.rest.service.base.AbstractService;

@Service
public class EnderecoServiceImpl extends AbstractService<Endereco, Long> implements EnderecoService{

	@Autowired
	EnderecoRepository repository;

	@Override
	public Endereco createEndereco(String cep, String logradouro, String numero, String complemento, String bairro,
			String cidade, String uf) {

		Endereco endereco = new Endereco(cep, logradouro, numero, complemento, bairro, cidade, uf, "BR", true);
		return repository.save(endereco);
	}
}
