package br.com.af.techcontrol.rest.entity.condominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.af.techcontrol.rest.entity.Funcionario;
import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import br.com.af.techcontrol.rest.entity.base.Pessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Condominio extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@NonNull
	private String finalidade;

	@NonNull
	private String tipoCondominio;

	@NonNull
	private Boolean isEnable;

	@NonNull
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "condominio_id")
	private List<Bloco> blocos;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "condominio_id")
	private List<EspacoComum> espacos;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "condominio_id")
	private List<Funcionario> funcionarios;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "condominio_id")
	private List<Avisos> avisos;

}
