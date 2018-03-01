package br.com.af.techcontrol.rest.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import br.com.af.techcontrol.rest.entity.base.Endereco;
import br.com.af.techcontrol.rest.entity.base.Telefone;

public interface AdministradorInfo {

	String getId();
	
	@Value("#{target.pessoa.nome}")
	String getNome();
	
	@Value("#{target.pessoa.tipoPessoa}")
	String getTipoPessoa();
	
	@Value("#{target.pessoa.cpfOuCnpj}")
	String getCpfOuCnpj();

	@Value("#{target.pessoa.email}")
	String getEmail();
	
	@Value("#{target.pessoa.enderecos}")
	List<Endereco> getEnderecos();

	@Value("#{target.pessoa.telefones}")
	List<Telefone> getTelefones();
}
