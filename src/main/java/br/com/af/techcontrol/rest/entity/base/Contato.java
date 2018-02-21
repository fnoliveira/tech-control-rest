package br.com.af.techcontrol.rest.entity.base;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contato extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;
	
	@NonNull
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "contatos_telefones", 
		joinColumns = @JoinColumn(name = "contato_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "telefone_id",
		referencedColumnName = "id"))
	private List<Telefone> telefones;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="contato_id")
	private List<Email> emails;

}
