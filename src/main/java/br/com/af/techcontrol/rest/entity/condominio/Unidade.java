package br.com.af.techcontrol.rest.entity.condominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.com.af.techcontrol.rest.entity.Funcionario;
import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import br.com.af.techcontrol.rest.entity.condomino.Animal;
import br.com.af.techcontrol.rest.entity.condomino.Condomino;
import br.com.af.techcontrol.rest.entity.condomino.Correspondencia;
import br.com.af.techcontrol.rest.entity.condomino.Veiculo;
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

	@NonNull
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Condomino> condominos;

	@NonNull
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Vaga> vagas;

	@NonNull
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Veiculo> veiculos;

	@NonNull
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Funcionario> funcionarios;

	@NonNull
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Animal> animais;

	@NonNull
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Correspondencia> correspondencias;

	@NonNull
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Reserva> reservas;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}
