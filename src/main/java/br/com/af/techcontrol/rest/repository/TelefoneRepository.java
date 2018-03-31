package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.af.techcontrol.rest.entity.base.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long>{

	public Telefone findByDddAndNumero(Long contatoId, String ddd, String numero);
	
}
