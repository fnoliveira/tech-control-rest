package br.com.af.techcontrol.rest.entity.condominio;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import br.com.af.techcontrol.rest.entity.condomino.Veiculo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Vaga extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	private String nome;

	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name = "vaga_id", referencedColumnName = "id")
	private Veiculo veiculo;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}
