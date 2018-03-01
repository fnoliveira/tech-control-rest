package br.com.af.techcontrol.rest.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.af.techcontrol.rest.dto.ReservaDto;
import br.com.af.techcontrol.rest.entity.condominio.Reserva;
import br.com.af.techcontrol.rest.repository.ReservaRepository;

public class ReservaService {
	
	@Autowired
	ReservaRepository reservaRepository;
	
	public List<Reserva> findByUnidadeId(Long unidadeId){
		
		List<Reserva> reservas = reservaRepository.findByUnidadeId(unidadeId);
				
		return reservas;
		
	}
	
	public List<Reserva> findByEspacoComunId(Long espacoComunId){
		
		
		List<Reserva> reservas = reservaRepository.findByEspacoComunId(espacoComunId);
		
		return reservas;
		
	}
	
	public List<Reserva> findByDateIniAndDateFim(LocalDateTime start, LocalDateTime end){
		
		
		List<Reserva> reservas = reservaRepository.findByDateIniAndDateFim(start, end);
		
		return reservas;
		
	}
	
	public List<Reserva> findByEspacoComunIdAndDateIniAndDateFim(Long espacoComunId, LocalDateTime start, LocalDateTime end){
		
		
		List<Reserva> reservas = reservaRepository.findByEspacoComunIdAndDateIniAndDateFim(espacoComunId, start, end);
		
		return reservas;
		
	}
	
	public Reserva save (Reserva reserva) {
		return reservaRepository.save(reserva);
	}
	
	public Reserva update (Reserva reserva) {
		return reservaRepository.save(reserva);
	}
	
	public Reserva findOne(Long reservaId) {
		return reservaRepository.findOne(reservaId);
	}
	
	public void delete (Long reservaId) {
		reservaRepository.delete(reservaId);;
	}

}
