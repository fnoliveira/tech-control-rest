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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class EspacoComum {
	
	@Id
	private long id;
	
	private String nome;

	private String descricao;
	
	private int lotacao;
	
	private boolean isPermiteInadimplente;
	
	private boolean isPermiteReserva;
	
	@ManyToOne
    @JoinColumn(name = "fk_condominio")
	private Condominio condominio;
	
	@OneToMany(mappedBy = "espacoComum")
	private List<Reserva> reservas;
	
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
