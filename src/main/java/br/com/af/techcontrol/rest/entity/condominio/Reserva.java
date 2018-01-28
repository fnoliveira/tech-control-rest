package br.com.af.techcontrol.rest.entity.condominio;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.af.techcontrol.rest.entity.base.BaseEntity;
import br.com.af.techcontrol.rest.entity.condomino.Unidade;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Reserva extends BaseEntity {

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
