package br.com.af.techcontrol.rest.entity.base;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "PESSOA")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO_DE_PESSOA")
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class Pessoa extends BaseEntityAudit {

	@NotBlank
	@Column(name = "nome", length = 50)
	private String nome;
	
	@Column(name = "observacao", length = 255)
	private String observacao;
    
}
