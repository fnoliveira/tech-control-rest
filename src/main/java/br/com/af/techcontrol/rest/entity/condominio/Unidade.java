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
public class Unidade extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String nome;
	
	@NonNull
	private Boolean isEnable;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Condomino> condominos;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Vaga> vagas;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Veiculo> veiculos;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Funcionario> funcionarios;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Animal> animais;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Correspondencia> correspondencias;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id", referencedColumnName = "id")
	private List<Reserva> reservas;

}
