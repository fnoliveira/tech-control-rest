package br.com.af.techcontrol.rest.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Animal extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "fk_unidade")
	private Unidade unidade;

}
