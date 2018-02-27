package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.af.techcontrol.rest.dto.AdministradorInfo;
import br.com.af.techcontrol.rest.entity.condominio.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

	@Query("select a from Administrador a join a.pessoa p join p.enderecos e"
			+ " where  p.nome = :nome")
	AdministradorInfo findByNameProjection(@Param("nome") String nome);

}
