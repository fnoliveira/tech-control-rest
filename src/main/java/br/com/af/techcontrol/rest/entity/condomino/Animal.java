package br.com.af.techcontrol.rest.entity.condomino;

import javax.persistence.Entity;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Animal extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	private String nome;

	@NonNull
	@Getter
	@Setter
	private String raca;

	@NonNull
	@Getter
	@Setter
	private String cor;

	@NonNull
	@Getter
	@Setter
	private String sexo;

	@NonNull
	@Getter
	@Setter
	private String foto;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}
