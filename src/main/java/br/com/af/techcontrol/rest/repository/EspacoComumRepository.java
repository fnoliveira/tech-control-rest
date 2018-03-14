package br.com.af.techcontrol.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.af.techcontrol.rest.entity.condominio.EspacoComum;


public interface EspacoComumRepository extends JpaRepository<EspacoComum, Long>{
	
	public EspacoComum findByNome(String nome);
	
	@Query(value="SELECT e.* FROM espaco_comum e where e.condominio_id = :condominioId",nativeQuery=true)
	public List<EspacoComum>findByCondominio(@Param("condominioId")Long condominioId);

}
