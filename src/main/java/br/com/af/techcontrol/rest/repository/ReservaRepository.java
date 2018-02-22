package br.com.af.techcontrol.rest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.entity.condominio.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
	List<Reserva> findByUnidadeId(Long unidadeId);
	
	List<Reserva> findByEspacoComunId(Long espacoComunId);
	
	List<Reserva> findByDateIniAndDateFim(Date start, Date end);
	

}
