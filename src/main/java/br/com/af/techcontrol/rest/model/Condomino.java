package br.com.af.techcontrol.rest.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Condomino {

	@Id
	private long id;
	
	private String nome;
	
	private String cpf;
	
	private boolean isProprietario;
	
	@ManyToOne
    @JoinColumn(name = "fk_unidade")
	private Unidade unidade;
	
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "contato_id", unique = true, nullable = true, insertable = true, updatable = true)
	private Contato contato;
	
	

	
}
