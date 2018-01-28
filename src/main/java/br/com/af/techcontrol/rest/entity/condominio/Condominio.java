package br.com.af.techcontrol.rest.entity.condominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import br.com.af.techcontrol.rest.entity.base.Contato;
import br.com.af.techcontrol.rest.entity.base.Endereco;
import br.com.af.techcontrol.rest.entity.base.Funcionario;
import br.com.af.techcontrol.rest.entity.base.Pessoa;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Condominio extends BaseEntityAudit {

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	private String finalidade;

	private String tipoCondominio;

	@OneToOne
	@JoinColumn(name = "fk_endereco")
	private Endereco endereco;

	@OneToOne
	@JoinColumn(name = "fk_contato")
	private Contato contato;

	@OneToMany(mappedBy = "condominio")
	private List<Funcionario> funcionarios;

	@ManyToOne
	@JoinColumn(name = "fk_administrador")
	private Administrador administrador;

	@OneToMany(mappedBy = "condominio")
	private List<EspacoComum> espacos;

	@OneToMany(mappedBy = "condominio")
	private List<Avisos> avisos;

	@OneToMany(mappedBy = "condominio")
	private List<Bloco> blocos;

}
