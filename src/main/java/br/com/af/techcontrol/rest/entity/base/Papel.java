package br.com.af.techcontrol.rest.entity.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Papel extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 3, max = 50)
	@Column(length = 50)
	private String nome;

	@Getter
	@Setter
	@Size(min = 3, max = 100)
	@Column(length = 100)
	private String descricao;

}
