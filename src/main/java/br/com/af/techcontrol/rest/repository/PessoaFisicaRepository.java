package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.entity.base.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long>{

	public PessoaFisica findByNome(String nome);
	
}
