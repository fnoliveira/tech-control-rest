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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Condominio extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@NonNull
	private String finalidade;

	@NonNull
	private String tipoCondominio;

	@NonNull
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_endereco")
	private Endereco endereco;

	@NonNull
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_contato")
	private Contato contato;

	@NonNull
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "condominio")
	private List<Bloco> blocos;

	@NonNull
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "condominio")
	private List<EspacoComum> espacos;

	@NonNull
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "condominio")
	private List<Funcionario> funcionarios;

	@NonNull
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "condominio")
	private List<Avisos> avisos;

	@NonNull
	private Boolean isEnable;

	@ManyToOne
	@JoinColumn(name = "fk_administrador")
	private Administrador administrador;

}
