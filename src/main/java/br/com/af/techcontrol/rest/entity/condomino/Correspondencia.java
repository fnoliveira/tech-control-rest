package br.com.af.techcontrol.rest.entity.condomino;

import javax.persistence.Entity;

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
	
	private String nome;
	

}
