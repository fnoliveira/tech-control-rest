package br.com.af.techcontrol.rest.entity.condominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Bloco extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private Long id;

	@NonNull
	@Getter
	@Setter
	@NotBlank
	private String nome;

	@Getter
	@Setter
	@OneToMany
	@JoinColumn(name = "bloco_id", referencedColumnName = "id")
	private List<Unidade> unidades = new ArrayList<Unidade>();
	
	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;
}
