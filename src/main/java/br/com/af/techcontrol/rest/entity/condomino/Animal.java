package br.com.af.techcontrol.rest.entity.condomino;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Animal extends BaseEntityAudit {

	@ManyToOne
	@JoinColumn(name = "fk_unidade")
	private Unidade unidade;

}
