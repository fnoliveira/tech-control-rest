package br.com.af.techcontrol.rest.entity.condominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Reserva extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	private String title;

	@NonNull
	@Getter
	@Setter
	private String description;

	@NonNull
	@Getter
	@Setter
	private LocalDateTime start;

	@NonNull
	@Getter
	@Setter
	private LocalDateTime end;

	@Getter
	@Setter
	@ManyToMany(mappedBy = "reservas")
	private List<EspacoComum> espacosComuns = new ArrayList<EspacoComum>();

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}
