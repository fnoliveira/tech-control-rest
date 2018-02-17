package br.com.af.techcontrol.rest.entity.condominio;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Avisos extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

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
