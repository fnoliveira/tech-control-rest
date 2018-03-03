package br.com.af.techcontrol.rest.entity.condominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import br.com.af.techcontrol.rest.entity.base.Pessoa;
import br.com.af.techcontrol.rest.entity.funcionario.Funcionario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Condominio extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@NonNull
	@Getter
	@Setter
	private String finalidade;

	@NonNull
	@Getter
	@Setter
	private String tipoCondominio;

	@NonNull
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "condominio_id", referencedColumnName = "id")
	private List<Bloco> blocos;

	@Getter
	@Setter
	@OneToMany
	@JoinColumn(name = "condominio_id", referencedColumnName = "id")
	private List<EspacoComum> espacos;

	@Getter
	@Setter
	@ManyToMany
	@JoinTable(name = "condominios_funcionarios", joinColumns = @JoinColumn(name = "condominio_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "funcionario_id", referencedColumnName = "id"))
	private List<Funcionario> funcionarios;

	@Getter
	@Setter
	@OneToMany
	@JoinColumn(name = "condominio_id", referencedColumnName = "id")
	private List<Avisos> avisos;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}
