package br.com.af.techcontrol.rest.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Email {

	@Id
	private long id;
	
	private String tipo;
	
	private String endereco;

	private boolean isPrincipal;
	
	@ManyToOne
    @JoinColumn(name = "fk_contato")
	private Contato contato;
}
