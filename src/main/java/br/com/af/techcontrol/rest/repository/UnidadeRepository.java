package br.com.af.techcontrol.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.af.techcontrol.rest.entity.condominio.Unidade;

public interface UnidadeRepository extends JpaRepository<Unidade, Long>{
	
	@Query(value="SELECT u.* FROM unidade u where u.bloco_id = :blocoId",nativeQuery=true)
	public List<Unidade> findByBlocoId(@Param("blocoId")Long blocoId);

}
