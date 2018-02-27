package br.com.af.techcontrol.rest.entity.condominio;

import javax.persistence.Entity;

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
public class Vaga extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	private String nome;
	
}
