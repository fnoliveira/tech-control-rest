package br.com.af.techcontrol.rest.entity.condominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import br.com.af.techcontrol.rest.entity.base.Pessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
public class Condominio extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	private String finalidade;

	private String tipoCondominio;

	@OneToMany
	@JoinColumn(name = "condominio_id", referencedColumnName = "id")
	private List<EspacoComum> espacos;

	@OneToMany
	@JoinColumn(name = "condominio_id", referencedColumnName = "id")
	private List<Avisos> avisos;

	private Boolean isEnable;

}
