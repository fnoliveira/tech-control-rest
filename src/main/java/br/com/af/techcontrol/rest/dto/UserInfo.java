package br.com.af.techcontrol.rest.dto;

public interface UserInfo {

	Long getPessoaId();
	
	String getNome();
	
	Long getUserId();
	
	String getUsername();

	Boolean getIsEnable();
}