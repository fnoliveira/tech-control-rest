package br.com.af.techcontrol.rest.dto;

import org.springframework.beans.factory.annotation.Value;

public interface AdministradorInfo {

	String getId();
	
	@Value("#{target.funcionario.pessoa.nome}")
	String getNome();
	
	@Value("#{target.funcionario.pessoa.tipoPessoa}")
	String getTipoPessoa();
	
	@Value("#{target.funcionario.pessoa.cpfOuCnpj}")
	String getCpfOuCnpj();
	

}
