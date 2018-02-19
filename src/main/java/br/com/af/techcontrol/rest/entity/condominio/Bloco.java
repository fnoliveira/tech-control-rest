package br.com.af.techcontrol.rest.entity.condominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import br.com.af.techcontrol.rest.entity.condomino.Unidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bloco extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@NotBlank
	private String nome;

	@NonNull
	@ManyToOne
	@JoinColumn(name = "condominio_id")
	private Condominio condominio;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "bloco")
	private List<Unidade> unidades;
}
