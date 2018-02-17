package br.com.af.techcontrol.rest.entity.condomino;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vaga extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "fk_unidade")
	private Unidade unidade;

}
