package br.com.af.techcontrol.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.PessoaFisica;
import br.com.af.techcontrol.rest.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {

	@Autowired
	PessoaFisicaRepository repository;

	public List<PessoaFisica> findAll() {
		return repository.findAll();
	}

	public PessoaFisica save(PessoaFisica pessoaFisica) {
		return repository.save(pessoaFisica);
	}

	public PessoaFisica findOne(Long pessoaFisicaId) {
		return repository.findOne(pessoaFisicaId);
	}

	public void delete(Long pessoaFisicaId) {
		repository.delete(pessoaFisicaId);
	}
}
