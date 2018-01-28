package br.com.af.techcontrol.rest.entity.base;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Email extends BaseEntity {

	private String tipo;

	private String endereco;

	private boolean isPrincipal;

	@ManyToOne
	@JoinColumn(name = "fk_contato")
	private Contato contato;

}
