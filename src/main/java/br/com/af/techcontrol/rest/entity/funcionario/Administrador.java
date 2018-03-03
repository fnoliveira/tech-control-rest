package br.com.af.techcontrol.rest.entity.funcionario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import br.com.af.techcontrol.rest.entity.condominio.Condominio;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Administrador extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "funcionario_id", referencedColumnName = "id")
	private Funcionario funcionario;

	@Getter
	@Setter
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "administrador_id", referencedColumnName = "id")
	private List<Condominio> condominios = new ArrayList<Condominio>();

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}
