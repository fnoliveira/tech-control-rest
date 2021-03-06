package br.com.af.techcontrol.rest.entity.condominio;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
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
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime start;

	@Getter
	@Setter
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime end;
}
