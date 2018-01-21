package br.com.af.techcontrol.rest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Telefone {

	@Id
	private long id;
	
	private String tipo;
	
	private String ddd;
	
	private String numero;
	
	@ManyToOne
    @JoinColumn(name = "fk_contato")
	private Contato contato;
}
