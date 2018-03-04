package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.entity.condominio.EspacoComum;


public interface EspacoComumRepository extends JpaRepository<EspacoComum, Long>{
	
	public EspacoComum findByNome(String nome);

}
