package br.com.af.techcontrol.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Reserva {

	@Id
	private long id;

	private String title;

	private String description;

	private String start;

	private String end;

	@ManyToOne
	@JoinColumn(name = "fk_unidade")
	private Unidade unidade;

	@ManyToOne
	@JoinColumn(name = "fk_espacoComum")
	private EspacoComum espacoComum;
}
