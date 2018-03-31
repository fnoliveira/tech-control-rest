package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.af.techcontrol.rest.entity.condominio.Bloco;

@Repository
public interface BlocoRepository extends JpaRepository<Bloco, Long> {
	public Bloco findByNome(String nome);
}
