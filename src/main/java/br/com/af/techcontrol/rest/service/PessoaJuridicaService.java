package br.com.af.techcontrol.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void delete(Long pessoaJuridicaId) {
		repository.delete(pessoaJuridicaId);
	}
}
