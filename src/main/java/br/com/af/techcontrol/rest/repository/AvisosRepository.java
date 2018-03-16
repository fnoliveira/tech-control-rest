package br.com.af.techcontrol.rest.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.af.techcontrol.rest.entity.condominio.Avisos;

public interface AvisosRepository extends JpaRepository<Avisos, Long> {
	
	@Query(value="SELECT a.* FROM avisos a where a.condominio_id = :condominio_id",nativeQuery=true)
	List<Avisos> findByCondominioId(@Param("condominio_id")Long condominio_id);
	
	@Query(value="SELECT a.* FROM avisos a where a.is_fixo = :is_fixo and a.condominio_id = :condominio_id",nativeQuery=true)
	List<Avisos> findByIsFixo(@Param("is_fixo")Boolean is_fixo, @Param("condominio_id")Long condominio_id);
	
	@Query(value="SELECT a.* FROM avisos a where :now between a.start and a.end and a.condominio_id = :condominio_id",nativeQuery=true)
	List<Avisos> findByStartAndEnd(@Param("now")LocalDateTime now, @Param("condominio_id")Long condominio_id);

}
