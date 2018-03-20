package br.com.af.techcontrol.rest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.condominio.Reserva;
import br.com.af.techcontrol.rest.repository.ReservaRepository;
import br.com.af.techcontrol.rest.service.base.AbstractService;

@Service
public class ReservaServiceImpl extends AbstractService<Reserva, Long> implements ReservaService{
	
	@Autowired
	ReservaRepository reservaRepository;
	
	@Override
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
