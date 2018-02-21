package br.com.af.techcontrol.rest.entity.base;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Email extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String tipo;

	@NonNull
	private String endereco;

	@NonNull
	private Boolean isPrincipal;

	@NonNull
	private Boolean isEnable;
	
}
