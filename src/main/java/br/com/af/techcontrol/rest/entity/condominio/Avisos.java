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
public class Avisos extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	private String destinatario;

	@NonNull
	@Getter
	@Setter
	private String titulo;

	@NonNull
	@Getter
	@Setter
	private String aviso;

	@NonNull
	@Getter
	@Setter
	private String anexo;

	@NonNull
	@Getter
	@Setter
	private Boolean isUrgente;

	@NonNull
	@Getter
	@Setter
	private Boolean isFixo;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;
	
	@Getter
	@Setter
	private LocalDateTime start;

	@Getter
	@Setter
	private LocalDateTime end;
}
