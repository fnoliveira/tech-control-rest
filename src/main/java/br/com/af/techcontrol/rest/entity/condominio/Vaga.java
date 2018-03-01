package br.com.af.techcontrol.rest.entity.condominio;

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
public class Vaga extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	private String nome;
	
	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;
	
}
