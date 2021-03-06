package br.com.af.techcontrol.rest.entity.condominio;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reserva extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String title;

	@Getter
	@Setter
	private String description;

	@Getter
	@Setter
	private LocalDateTime start;

	@Getter
	@Setter
	private LocalDateTime end;

	/*@Getter
	@Setter
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "condomino_id")
	private Condomino condomino;*/

	/*@Getter
	@Setter
	@ManyToMany(mappedBy = "reservas")
	private List<EspacoComum> espacosComuns;*/

	@Getter
	@Setter
	private Boolean isEnable;
}
