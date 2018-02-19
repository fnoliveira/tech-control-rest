package br.com.af.techcontrol.rest.entity.condomino;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import br.com.af.techcontrol.rest.entity.base.Contato;
import br.com.af.techcontrol.rest.entity.base.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Condomino extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	private boolean isProprietario;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "contato_id")
	private Contato contato;

	@ManyToOne
	@JoinColumn(name = "unidade_id")
	private Unidade unidade;
}
