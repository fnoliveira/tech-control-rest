package br.com.af.techcontrol.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.PessoaJuridica;
import br.com.af.techcontrol.rest.entity.condominio.Condominio;
import br.com.af.techcontrol.rest.repository.CondominioRepository;

@Service
@Transactional
public class CondominioService {

	@Autowired
	CondominioRepository repository;

	@Autowired
	private PessoaJuridicaService pessoaJuridicaService;
	
	public List<Condominio> findAll() {
		return repository.findAll();
	}

	public Condominio save(Condominio condominio) {
		return repository.save(condominio);
	}

	public Condominio findOne(Long id) {
		return repository.findOne(id);
	}

	public void delete(Long id) {
		repository.delete(id);
	}
	
	public Condominio findByPessoaId(Long id) {
		return repository.findByPessoaId(id);
	}
	
	public Condominio findByCNPJ(String cnpj) {
		PessoaJuridica pj = pessoaJuridicaService.findByCnpj(cnpj);
		
		Condominio condominio =  findByPessoaId(pj.getId());
		
		return repository.findOne(condominio.getId());
	}
}
