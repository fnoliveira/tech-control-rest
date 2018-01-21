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
public class Condominio {

	@Id
	private long id;

	private String nome;
	
	@ManyToOne
    @JoinColumn(name = "fk_administracao")
	private Administracao administracao;
	
	@OneToMany(mappedBy = "condominio")
	private List<EspacoComum> espacos;
	
	@OneToMany(mappedBy = "condominio")
	private List<Bloco> blocos;
	
	
}
