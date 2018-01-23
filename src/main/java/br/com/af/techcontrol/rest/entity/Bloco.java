package br.com.af.techcontrol.rest.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Bloco extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "fk_condominio")
	private Condominio condominio;

	@OneToMany(mappedBy = "bloco")
	private List<Unidade> unidades;

}
