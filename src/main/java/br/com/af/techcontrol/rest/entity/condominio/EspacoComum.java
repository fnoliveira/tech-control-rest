package br.com.af.techcontrol.rest.entity.condominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class EspacoComum extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	private String nome;

	@NonNull
	@Getter
	@Setter
	private String descricao;

	@NonNull
	@Getter
	@Setter
	private Integer lotacao;

	@NonNull
	@Getter
	@Setter
	private Boolean isPermiteInadimplente;

	@NonNull
	@Getter
	@Setter
	private Boolean isPermiteReserva;

	@Getter
	@Setter
	@Fetch(FetchMode.SELECT)
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "espacoComum_reservas", joinColumns = @JoinColumn(name = "espacoComum_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "reserva_id", referencedColumnName = "id"))
	private List<Reserva> reservas;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;
}
