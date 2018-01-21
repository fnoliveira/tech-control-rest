package br.com.af.techcontrol.rest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Bloco {

	@Id
	private long id;
	
	@ManyToOne
    @JoinColumn(name = "fk_condominio")
	private Condominio condominio;
	
	@OneToMany(mappedBy = "bloco")
	private List<Unidade> unidades;
	
}
