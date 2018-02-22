package br.com.af.techcontrol.rest.service;

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
	
	public List<ReservaDto> findByUnidadeId(Long unidadeId){
		
		List<ReservaDto> retorno = new ArrayList<ReservaDto>();
		
		List<Reserva> reservas = reservaRepository.findByUnidadeId(unidadeId);
		if(reservas != null) {
			for (Reserva reserva : reservas) {
				retorno.add(new ReservaDto(reserva.getId().intValue(), 
											reserva.getTitle(), 
											reserva.getDescription(), 
											false, 
											reserva.getStart(), 
											reserva.getEnd(), 
											null,
											reserva.getUnidade().getNome(),
											reserva.getUnidade().getBloco().getNome(),
											reserva.getEspacoComum().getNome()));
			}
		}
		
		return retorno;
		
	}
	
	public List<ReservaDto> findByEspacoComunId(Long espacoComunId){
		
		List<ReservaDto> retorno = new ArrayList<ReservaDto>();
		
		List<Reserva> reservas = reservaRepository.findByEspacoComunId(espacoComunId);
		if(reservas != null) {
			for (Reserva reserva : reservas) {
				retorno.add(new ReservaDto(reserva.getId().intValue(), 
											reserva.getTitle(), 
											reserva.getDescription(), 
											false, 
											reserva.getStart(), 
											reserva.getEnd(), 
											null, 
											reserva.getUnidade().getNome(),
											reserva.getUnidade().getBloco().getNome(),
											reserva.getEspacoComum().getNome()));
			}
		}
		
		return retorno;
		
	}
	
	public List<ReservaDto> findByDateIniAndDateFim(Date start, Date end){
		
		List<ReservaDto> retorno = new ArrayList<ReservaDto>();
		
		List<Reserva> reservas = reservaRepository.findByDateIniAndDateFim(start, end);
		if(reservas != null) {
			for (Reserva reserva : reservas) {
				retorno.add(new ReservaDto(reserva.getId().intValue(), 
											reserva.getTitle(), 
											reserva.getDescription(), 
											false, 
											reserva.getStart(), 
											reserva.getEnd(), 
											null, 
											reserva.getUnidade().getNome(),
											reserva.getUnidade().getBloco().getNome(),
											reserva.getEspacoComum().getNome()));
			}
		}
		
		return retorno;
		
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
