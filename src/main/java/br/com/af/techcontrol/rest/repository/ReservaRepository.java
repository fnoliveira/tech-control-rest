package br.com.af.techcontrol.rest.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.af.techcontrol.rest.entity.condominio.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
	@Query(value="SELECT r.* FROM reserva r where :start between r.start and r.end and r.espaco_comum_id = :espaco_comum_id",nativeQuery=true)
	public List<Reserva> findByStartAndEspacoComumId(@Param("start")LocalDateTime start, @Param("espaco_comum_id")Long espaco_comum_id);

}
