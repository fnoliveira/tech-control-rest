package br.com.af.techcontrol.rest.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Administracao extends BaseEntity {

	private String nome;

	private String cpf_cnpj;

	@OneToOne
	@JoinColumn(name = "fk_contato")
	private Contato contato;

	@OneToMany(mappedBy = "administracao")
	private List<Condominio> condominios;

}
