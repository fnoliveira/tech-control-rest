package br.com.af.techcontrol.rest.entity.base;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Contato extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "pessoa_id")
	Pessoa pessoa;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "contato")
	private List<Telefone> telefones;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "contato")
	private List<Email> emails;

}
