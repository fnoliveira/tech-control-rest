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
public class Veiculo extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	private String tipo;

	@NonNull
	@Getter
	@Setter
	private String placa;

	@NonNull
	@Getter
	@Setter
	private String marca;

	@NonNull
	@Getter
	@Setter
	private String modelo;

	@NonNull
	@Getter
	@Setter
	private String cor;

	@NonNull
	@Getter
	@Setter
	private String ano;

	@NonNull
	@Getter
	@Setter
	private String foto;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}
