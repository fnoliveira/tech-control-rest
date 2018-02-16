package br.com.af.techcontrol.rest.entity.base;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Contato extends BaseEntityAudit {

	@OneToMany(mappedBy = "contato")
	private List<Telefone> telefones;

	@OneToMany(mappedBy = "contato")
	private List<Email> emails;

}
