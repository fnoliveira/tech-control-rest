package br.com.af.techcontrol.rest.entity.base;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "PESSOA_JURIDICA")
@DiscriminatorValue(value = "PJ")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaJuridica extends Pessoa {
 
	@NotBlank
	@Column(name = "razao_social", length = 100)
	private String razaoSocial;
	
	@NotBlank
	@Column(name = "cnpj", length = 14)
	private String cnpj;
	
	@Column(name = "inscricao_estadual", length = 15)
	private String inscricaoEstadual;
	
	@Column(name = "inscricao_municipal", length = 15)
	private String inscricaoMunicipal;

}

