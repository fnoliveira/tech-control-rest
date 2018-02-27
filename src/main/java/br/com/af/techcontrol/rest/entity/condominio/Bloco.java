package br.com.af.techcontrol.rest.entity.condominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "bloco_id", referencedColumnName = "id")
	private List<Unidade> unidades;
}
