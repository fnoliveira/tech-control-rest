package br.com.af.techcontrol.rest.entity.condomino;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.af.techcontrol.rest.entity.base.BaseEntityAudit;
import br.com.af.techcontrol.rest.entity.base.Pessoa;
import br.com.af.techcontrol.rest.entity.condominio.Reserva;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Condomino extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private Pessoa pessoa;

	@NonNull
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "condomino_id", referencedColumnName = "id")
	private List<Animal> animais;
	
	@NonNull
	@Getter
	@Setter
	private Boolean isProprietario;
	
	@Getter
	@Setter
	@OneToOne(mappedBy = "condomino", cascade = CascadeType.ALL)
	private Reserva reserva;
	
	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}
