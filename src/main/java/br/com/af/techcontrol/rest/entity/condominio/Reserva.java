package br.com.af.techcontrol.rest.entity.condominio;

import java.time.LocalDateTime;

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

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;
}
