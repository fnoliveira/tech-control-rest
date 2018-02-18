package br.com.af.techcontrol.rest.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.Endereco;
import br.com.af.techcontrol.rest.entity.base.PessoaJuridica;
import br.com.af.techcontrol.rest.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {

	@Autowired
	PessoaJuridicaRepository repository;

	public List<PessoaJuridica> findAll() {
		return repository.findAll();
	}

	public PessoaJuridica save(PessoaJuridica pessoaJuridica) {
		return repository.save(pessoaJuridica);
	}

	public PessoaJuridica findOne(Long pessoaJuridicaId) {
		return repository.findOne(pessoaJuridicaId);
	}

	public PessoaJuridica findByNomeFantasia(String nome) {
		return repository.findByNome(nome);
	}

	public PessoaJuridica findByRazaoSocial(String razaosocial) {
		return repository.findByRazaoSocial(razaosocial);
	}

	public PessoaJuridica findByCnpj(String cnpj) {
		return repository.findByCnpj(cnpj);
	}

	public void delete(Long pessoaJuridicaId) {
		repository.delete(pessoaJuridicaId);
	}
	
	public PessoaJuridica createPessoaPJIfNotFound(String nomefantasia, String razaosocial, String cnpj,
			Collection<Endereco> enderecos) {

		PessoaJuridica pessoaJuridica = findByCnpj(cnpj);

		if (pessoaJuridica == null) {
			pessoaJuridica = new PessoaJuridica();
			pessoaJuridica.setNome(nomefantasia);
			pessoaJuridica.setRazaoSocial(razaosocial);
			pessoaJuridica.setCnpj(cnpj);
			pessoaJuridica.setEnderecos(enderecos);
			pessoaJuridica.setIsEnable(true);
			return save(pessoaJuridica);
		}

		return pessoaJuridica;
	}
}
