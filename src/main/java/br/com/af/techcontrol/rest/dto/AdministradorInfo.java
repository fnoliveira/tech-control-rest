package br.com.af.techcontrol.rest.dto;

import java.util.List;

import br.com.af.techcontrol.rest.entity.base.Telefone;

public interface AdministradorInfo {

	String getNome();
	
	
	List<Telefone> getTelefones();
}
