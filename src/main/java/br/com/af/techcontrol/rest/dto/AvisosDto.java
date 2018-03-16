package br.com.af.techcontrol.rest.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AvisosDto {

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
