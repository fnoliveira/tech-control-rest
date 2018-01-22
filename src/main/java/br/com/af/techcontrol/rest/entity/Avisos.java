package br.com.af.techcontrol.rest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Avisos {

	@Id
	private long id;
	
	private String destinatario;
	
	private String titulo;
	
	private String aviso;
	
	private String anexo;
	
	private boolean isUrgente;
	
	private boolean isFixo;
	
	@ManyToOne
    @JoinColumn(name = "fk_condominio")
	private Condominio condominio;
	
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