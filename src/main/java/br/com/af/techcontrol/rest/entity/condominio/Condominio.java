package br.com.af.techcontrol.rest.entity.condominio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.af.techcontrol.rest.entity.Funcionario;
import br.com.af.techcontrol.rest.entity.base.Pessoa;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor
public class Condominio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private Long id;

	@NonNull
	@Getter
	@Setter
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@NonNull
	@Getter
	@Setter
	private String finalidade;

	@NonNull
	@Getter
	@Setter
	private String tipoCondominio;

	@NonNull
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "condominio_id", referencedColumnName = "id")
	private List<Bloco> blocos;

	@NonNull
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "condominio_id", referencedColumnName = "id")
	private List<EspacoComum> espacos;

	@NonNull
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "condominio_id", referencedColumnName = "id")
	private List<Funcionario> funcionarios;

	@NonNull
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "condominio_id", referencedColumnName = "id")
	private List<Avisos> avisos;
	
	@Version
	private Long version;

	@Getter
	private String createdBy;

	@Getter
	private String updatedBy;

	@Getter
	@CreatedDate
	private LocalDateTime createdAt;

	@Getter
	@LastModifiedDate
	private LocalDateTime updatedAt;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}
