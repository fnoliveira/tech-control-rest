package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.entity.condominio.Condominio;

public interface CondominioRepository extends JpaRepository<Condominio, Long> {

	Condominio findByPessoaId(Long id);

	 
}
