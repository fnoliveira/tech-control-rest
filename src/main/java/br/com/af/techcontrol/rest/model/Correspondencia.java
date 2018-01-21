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
public class Correspondencia {

	@Id
	private long id;
	
	@ManyToOne
    @JoinColumn(name = "fk_unidade")
	private Unidade unidade;
}
