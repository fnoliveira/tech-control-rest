package br.com.af.techcontrol.rest.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import br.com.af.techcontrol.rest.entity.base.Pessoa;
import br.com.af.techcontrol.rest.entity.condominio.Condominio;
import br.com.af.techcontrol.rest.entity.condomino.Unidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Funcionario extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NotBlank
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@NotBlank
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataAdmissao;

	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date dataDemissao;

	@NotBlank
	@ManyToOne
	@JoinColumn(name = "condominio_id")
	private Condominio condominio;

	@ManyToOne
	@JoinColumn(name = "unidade_id")
	private Unidade unidade;
	
	private Boolean isEnable;

}
