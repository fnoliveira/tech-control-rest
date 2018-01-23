package br.com.af.techcontrol.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Vaga {

	@Id
	private long id;

	@ManyToOne
	@JoinColumn(name = "fk_unidade")
	private Unidade unidade;

}
