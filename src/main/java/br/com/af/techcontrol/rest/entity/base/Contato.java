package br.com.af.techcontrol.rest.entity.base;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contato extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "contato")
	private List<Telefone> telefones;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "contato")
	private List<Email> emails;

}
