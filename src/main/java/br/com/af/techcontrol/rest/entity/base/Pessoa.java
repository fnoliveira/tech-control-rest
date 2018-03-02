package br.com.af.techcontrol.rest.entity.base;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import br.com.af.techcontrol.rest.entity.base.validation.PessoaGroupSequenceProvider;
import br.com.af.techcontrol.rest.entity.base.validation.group.CnpjGroup;
import br.com.af.techcontrol.rest.entity.base.validation.group.CpfGroup;
import br.com.af.techcontrol.rest.enums.TipoPessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@GroupSequenceProvider(PessoaGroupSequenceProvider.class)
public class Pessoa extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 3, max = 50)
	@Column(length = 50)
	private String nome;

	@NonNull
	@Getter
	@Setter
	@NotNull(message = "Tipo pessoa é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pessoa")
	private TipoPessoa tipoPessoa;

	@NonNull
	@Getter
	@Setter
	@NotBlank(message = "CPF/CNPJ é obrigatório")
	@CPF(groups = CpfGroup.class)
	@CNPJ(groups = CnpjGroup.class)
	@Column(name = "cpf_cnpj", unique = true)
	private String cpfOuCnpj;

	@Getter
	@Setter
	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private User user;

	@Getter
	@Setter
	@Fetch(FetchMode.SELECT)
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pessoas_enderecos", joinColumns = @JoinColumn(name = "pessoa_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "endereco_id", referencedColumnName = "id"))
	private List<Endereco> enderecos;

	@Getter
	@Setter
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "pessoas_telefones", joinColumns = @JoinColumn(name = "pessoa_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "telefone_id", referencedColumnName = "id"))
	private List<Telefone> telefones;

	@NonNull
	@Getter
	@Setter
	@Email(message = "E-mail inválido")
	@Column(unique = true)
	private String email;

	@Getter
	@Setter
	@Size(min = 3, max = 255)
	@Column(length = 255)
	private String observacao;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

	@PrePersist
	@PreUpdate
	private void prePersistPreUpdate() {
		this.cpfOuCnpj = TipoPessoa.removerFormatacao(this.cpfOuCnpj);
	}

	@PostLoad
	private void postLoad() {
		this.cpfOuCnpj = this.tipoPessoa.formatar(this.cpfOuCnpj);
	}

	public String getCpfOuCnpjSemFormatacao() {
		return TipoPessoa.removerFormatacao(this.cpfOuCnpj);
	}
}
