package br.com.af.techcontrol.rest.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Condominio extends BaseEntity {

	private String nome;

	private String cnpj;

	private String finalidade;

	private String tipoCondominio;

	@OneToOne
	@JoinColumn(name = "fk_endereco")
	private Endereco endereco;

	@OneToOne
	@JoinColumn(name = "fk_contato")
	private Contato contato;

	@ManyToOne
	@JoinColumn(name = "fk_administracao")
	private Administracao administracao;

	@OneToMany(mappedBy = "condominio")
	private List<EspacoComum> espacos;

	@OneToMany(mappedBy = "condominio")
	private List<Avisos> avisos;

	@OneToMany(mappedBy = "condominio")
	private List<Bloco> blocos;

}
