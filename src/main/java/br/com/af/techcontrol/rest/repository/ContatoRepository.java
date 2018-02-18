package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.entity.base.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

	public Contato findByPessoaId(Long pessoaId);
	
}
