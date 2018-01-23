package br.com.af.techcontrol.rest.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Veiculo extends BaseEntity {

	private String tipo;

	private String placa;

	private String marca;

	private String modelo;

	private String cor;

	private String ano;

	private String foto;

	@ManyToOne
	@JoinColumn(name = "fk_unidade")
	private Unidade unidade;

}
