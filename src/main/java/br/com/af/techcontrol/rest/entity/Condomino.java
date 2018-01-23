package br.com.af.techcontrol.rest.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Condomino extends BaseEntity {

	private String nome;

	private String cpf;

	private boolean isProprietario;

	@ManyToOne
	@JoinColumn(name = "fk_unidade")
	private Unidade unidade;

	@OneToOne
	@JoinColumn(name = "fk_contato")
	private Contato contato;

}
