package br.com.af.techcontrol.rest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Contato {

	@Id
	private long id;

	@OneToMany(mappedBy="contato")
	private List<Telefone> telefones;

	@OneToMany(mappedBy="contato")
	private List<Email> email;

}
