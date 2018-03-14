package br.com.af.techcontrol.rest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.condominio.Reserva;
import br.com.af.techcontrol.rest.repository.ReservaRepository;

@Service
public class ReservaService {
	
	@Autowired
	ReservaRepository reservaRepository;
	
	@Transactional
	public boolean existeReservaByData(LocalDateTime start, Long espacoComumId) {
		List<Reserva> reservas = reservaRepository.findByStartAndEspacoComumId(start, espacoComumId);
		
		if(reservas != null && reservas.size() > 0) { 
			return true;
		}else {
			return false;
		}
		
	}
	
	

}
