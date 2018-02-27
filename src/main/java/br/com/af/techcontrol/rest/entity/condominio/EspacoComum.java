package br.com.af.techcontrol.rest.entity.condominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
public class EspacoComum extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String nome;

	@NonNull
	private String descricao;

	@NonNull
	private Integer lotacao;

	@NonNull
	private Boolean isPermiteInadimplente;

	@NonNull
	private Boolean isPermiteReserva;

	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "espacoComum_id", referencedColumnName = "id")
	private List<Reserva> reservas;

	@NonNull
	private Boolean isEnable;

}
