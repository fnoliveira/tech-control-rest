package br.com.af.techcontrol.rest.entity.condominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import br.com.af.techcontrol.rest.entity.condomino.Unidade;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Bloco extends BaseEntityAudit {

	@ManyToOne
	@JoinColumn(name = "fk_condominio")
	private Condominio condominio;

	@OneToMany(mappedBy = "bloco")
	private List<Unidade> unidades;

}
