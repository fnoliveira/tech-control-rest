package br.com.af.techcontrol.rest.entity.condomino;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.af.techcontrol.rest.entity.Funcionario;
import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import br.com.af.techcontrol.rest.entity.condominio.Bloco;
import br.com.af.techcontrol.rest.entity.condominio.Reserva;
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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "unidade")
	private List<Condomino> condominos;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "unidade")
	private List<Vaga> vagas;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "unidade")
	private List<Veiculo> veiculos;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "unidade")
	private List<Funcionario> funcionarios;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "unidade")
	private List<Animal> animais;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "unidade")
	private List<Correspondencia> correspondencias;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "unidade")
	private List<Reserva> reservas;

	private Boolean isEnable;

	@ManyToOne
	@JoinColumn(name = "fk_bloco")
	private Bloco bloco;
}
