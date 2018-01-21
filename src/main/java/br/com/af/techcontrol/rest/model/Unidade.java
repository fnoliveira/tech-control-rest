package br.com.af.techcontrol.rest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Unidade {

	@Id
	private long id;

	@ManyToOne
    @JoinColumn(name = "fk_bloco")
	private Bloco bloco;
	
	@OneToMany(mappedBy = "unidade")
	private List<Condomino> condominos;

	@OneToMany(mappedBy = "unidade")
	private List<Vaga> vagas;

	@OneToMany(mappedBy = "unidade")
	private List<Veiculo> veiculos;

	@OneToMany(mappedBy = "unidade")
	private List<Funcionario> funcionarios;

	@OneToMany(mappedBy = "unidade")
	private List<Animal> animais;

	@OneToMany(mappedBy = "unidade")
	private List<Correspondencia> correspondencias;
	
	@OneToMany(mappedBy = "unidade")
	private List<Reserva> reservas;

}
