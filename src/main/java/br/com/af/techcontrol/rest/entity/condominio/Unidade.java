package br.com.af.techcontrol.rest.entity.condominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	@OneToMany
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Condomino> condominos;

	@Getter
	@Setter
	@OneToMany
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Vaga> vagas;

	@Getter
	@Setter
	@Fetch(FetchMode.SELECT)
	@ManyToMany
	@JoinTable(name = "unidades_funcionarios", joinColumns = @JoinColumn(name = "unidade_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "funcionario_id", referencedColumnName = "id"))
	private List<Funcionario> funcionarios;

	@Getter
	@Setter
	@OneToMany
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Correspondencia> correspondencias;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}
