package br.com.af.techcontrol.rest.entity.base;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Endereco extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String cep;

	@NonNull
	private String logradouro;

	@NonNull
	private String numero;

	@NonNull
	private String complemento;

	@NonNull
	private String bairro;

	@NonNull
	private String cidade;

	@NonNull
	private String uf;

	@NonNull
	private String pais;

	@NonNull
	private Boolean isEnable;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "enderecos")
    private List<Pessoa> pessoas;
}
