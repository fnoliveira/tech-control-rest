package br.com.af.techcontrol.rest.entity.condominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import br.com.af.techcontrol.rest.entity.condomino.Condomino;
import br.com.af.techcontrol.rest.entity.condomino.Correspondencia;
import br.com.af.techcontrol.rest.entity.funcionario.Funcionario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Unidade extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	private String nome;

	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Condomino> condominos;

	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Vaga> vagas;

	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Funcionario> funcionarios;

	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Correspondencia> correspondencias;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}
