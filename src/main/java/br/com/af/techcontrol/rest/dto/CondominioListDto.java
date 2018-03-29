package br.com.af.techcontrol.rest.dto;

public interface CondominioListDto {

	Long getCondominioId();

	String getNome();

	String getCpfOuCnpj();

	String getFinalidade();

	Boolean getIsEnable();
}