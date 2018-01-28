package br.com.af.techcontrol.rest.entity.base;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Telefone extends BaseEntity {

	private String tipo;

	private String ddd;

	private String numero;

	@ManyToOne
	@JoinColumn(name = "fk_contato")
	private Contato contato;

}
