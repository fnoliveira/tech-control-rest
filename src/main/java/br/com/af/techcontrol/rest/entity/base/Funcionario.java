package br.com.af.techcontrol.rest.entity.base;

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

import br.com.af.techcontrol.rest.entity.condominio.Condominio;
import br.com.af.techcontrol.rest.entity.condomino.Unidade;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Funcionario extends BaseEntityAudit {

	@NotBlank
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="pessoa_id")
    private Pessoa pessoa;
	
	@NotBlank
	@Temporal(TemporalType.DATE)
	@Column(name = "data_admissao", nullable = false)
	private Date dataAdmissao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_demissao", nullable = true)
	private Date dataDemissao;
	
	@NotBlank
	@ManyToOne
	@JoinColumn(name = "fk_condominio")
	private Condominio condominio;
	
	@ManyToOne
	@JoinColumn(name = "fk_unidade")
	private Unidade unidade;

}
