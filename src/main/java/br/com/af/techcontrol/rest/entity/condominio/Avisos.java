package br.com.af.techcontrol.rest.entity.condominio;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Avisos extends BaseEntityAudit {

	private String destinatario;

	private String titulo;

	private String aviso;

	private String anexo;

	private boolean isUrgente;

	private boolean isFixo;

	@ManyToOne
	@JoinColumn(name = "fk_condominio")
	private Condominio condominio;

}
