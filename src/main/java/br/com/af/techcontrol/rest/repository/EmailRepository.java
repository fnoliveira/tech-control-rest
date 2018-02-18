package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.entity.base.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{

	public Email findByContatoIdAndEndereco (Long contatoId, String endereco);
	
	public Email findByEndereco(String endereco); 
	
}
