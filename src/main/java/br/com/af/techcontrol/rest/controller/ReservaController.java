package br.com.af.techcontrol.rest.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.dto.ReservaDto;
import br.com.af.techcontrol.rest.entity.condominio.Administrador;
import br.com.af.techcontrol.rest.entity.condominio.Reserva;
import br.com.af.techcontrol.rest.response.Response;
import br.com.af.techcontrol.rest.service.ReservaService;
import br.com.af.techcontrol.rest.util.CustomErrorType;
import br.com.af.techcontrol.rest.util.LocalDateTimeUtil;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
	
	@Autowired
	ReservaService reservaService;

	@GetMapping
	public ResponseEntity<?> getReserva() {

		List<ReservaDto> eventos = new ArrayList<ReservaDto>();
		
		try {
			eventos.add(new ReservaDto(1, 
										"Festa Apto 113", 
										"Festa da Julia",
										false, 
										"2018-01-15T13:00:00", 
										"2018-01-15T18:00:00", 
										null));
		} catch (Exception e) {
			return new ResponseEntity<Object>(new CustomErrorType("Erro Exception " + e.getMessage()), HttpStatus.BAD_REQUEST);
		}

		
		return new ResponseEntity<List<ReservaDto>>(eventos, HttpStatus.OK);
	}
	
	@GetMapping(value="/{dataIni}/{dataFim}")
	public ResponseEntity<Response<List<Reserva>>> getReservas(@PathVariable("dataIni") String dataIni, @PathVariable("dataFim") String dataFim) {
		
		List<Reserva> eventos = new ArrayList<Reserva>();
		try {
			
			LocalDateTime dtIni = LocalDateTimeUtil.strToLocalDateTime(dataIni, "yyyyMMdd");
			LocalDateTime dtFim = LocalDateTimeUtil.strToLocalDateTime(dataFim, "yyyyMMdd");
			
			eventos = reservaService.findByDateIniAndDateFim(dtIni, dtFim);
			
			return ResponseEntity.ok(new Response<List<Reserva>>(eventos));
		} catch (Exception e) {
			List<String> erros = new ArrayList<String>();
			erros.add(e.getMessage());
			return ResponseEntity.badRequest().body(new Response<List<Reserva>>(erros));
		}

	}
	
	@GetMapping(value="/{unidadeId}")
	public ResponseEntity<Response<List<Reserva>>> getReservas(@PathVariable("unidadeId") Long unidadeId) {
		
		List<Reserva> eventos = new ArrayList<Reserva>();
		try {					
			
			eventos = reservaService.findByUnidadeId(unidadeId);
			
			return ResponseEntity.ok(new Response<List<Reserva>>(eventos));
		} catch (Exception e) {
			List<String> erros = new ArrayList<String>();
			erros.add(e.getMessage());
			return ResponseEntity.badRequest().body(new Response<List<Reserva>>(erros));
		}

	}
	
	@GetMapping(value="/espaco/{espacoComunId}")
	public ResponseEntity<Response<List<Reserva>>> getReservasEspacoComun(@PathVariable("espacoComunId") Long espacoComunId) {
		
		List<Reserva> eventos = new ArrayList<Reserva>();
		try {					
			
			eventos = reservaService.findByEspacoComunId(espacoComunId);
			
			return ResponseEntity.ok(new Response<List<Reserva>>(eventos));
		} catch (Exception e) {
			List<String> erros = new ArrayList<String>();
			erros.add(e.getMessage());
			return ResponseEntity.badRequest().body(new Response<List<Reserva>>(erros));
		}

	}
	
	@GetMapping(value="/espaco/{espacoComunId}/{dataIni}/{dataFim}")
	public ResponseEntity<Response<List<Reserva>>> getReservasEspacoComun(@PathVariable("espacoComunId") Long espacoComunId, @PathVariable("dataIni") String dataIni, @PathVariable("dataFim") String dataFim) {
		
		List<Reserva> eventos = new ArrayList<Reserva>();
		try {		
			
			LocalDateTime dtIni = LocalDateTimeUtil.strToLocalDateTime(dataIni, "yyyyMMdd");
			LocalDateTime dtFim = LocalDateTimeUtil.strToLocalDateTime(dataFim, "yyyyMMdd");
			
			eventos = reservaService.findByEspacoComunIdAndDateIniAndDateFim(espacoComunId, dtIni, dtFim);
					
			return ResponseEntity.ok(new Response<List<Reserva>>(eventos));
		} catch (Exception e) {
			List<String> erros = new ArrayList<String>();
			erros.add(e.getMessage());
			return ResponseEntity.badRequest().body(new Response<List<Reserva>>(erros));
		}

	}

}