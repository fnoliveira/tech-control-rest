package br.com.af.techcontrol.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Endereco {

	@Id
	private long id;

	private String cep;

	private String logradouro;

	private String numero;

	private String complemento;

	private String bairro;

	private String cidade;

	private String uf;

	private String pais;

}
