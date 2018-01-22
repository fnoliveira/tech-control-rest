package br.com.af.techcontrol.rest.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Condominio {

	@Id
	private long id;

	private String nome;

	private String cnpj;
	
	private String finalidade;
	
	private String tipoCondominio;

	@OneToOne
	@JoinColumn(name = "fk_endereco")
	private Endereco endereco;

	@OneToOne
	@JoinColumn(name = "fk_contato")
	private Contato contato;

	@ManyToOne
	@JoinColumn(name = "fk_administracao")
	private Administracao administracao;

	@OneToMany(mappedBy = "condominio")
	private List<EspacoComum> espacos;

	@OneToMany(mappedBy = "condominio")
	private List<Avisos> avisos;

	
	@OneToMany(mappedBy = "condominio")
	private List<Bloco> blocos;
	
	private String createdBy;

	private String updatedBy;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
