package br.com.af.techcontrol.rest.entity.condomino;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Veiculo extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	private String tipo;

	private String placa;

	private String marca;

	private String modelo;

	private String cor;

	private String ano;

	private String foto;

	@ManyToOne
	@JoinColumn(name = "unidade_id")
	private Unidade unidade;

}
