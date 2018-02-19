package br.com.af.techcontrol.rest.entity.condomino;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.af.techcontrol.rest.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Correspondencia extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "unidade_id")
	private Unidade unidade;

}
