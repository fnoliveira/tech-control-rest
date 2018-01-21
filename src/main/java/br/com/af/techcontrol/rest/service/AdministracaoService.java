package br.com.af.techcontrol.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.model.Administracao;
import br.com.af.techcontrol.rest.repository.AdministracaoRepository;

@Service
public class AdministracaoService {

	@Autowired
	AdministracaoRepository administracaoRepository;
	
	public List<Administracao> findAll(){

		CarregaTeste();
		
		return administracaoRepository.findAll();
	}
	
	public void CarregaTeste() {
		Administracao administracao = new Administracao();
		administracao.setId(1);
		administracao.setCpf_cnpj("31406826898");
		administracao.setNome("Francis Oliveira");
	}
	
	public Administracao save(Administracao administracao) {
		return administracaoRepository.save(administracao);
	}
}
