package br.com.af.techcontrol.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.dto.ReservaDto;
import br.com.af.techcontrol.rest.service.ReservaService;
import br.com.af.techcontrol.rest.util.CustomErrorType;
import br.com.af.techcontrol.rest.util.DateUtil;

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
										DateUtil.StrToDate("2018-01-15T13:00:00", "yyyy-MM-dd HH:mm:ss"), 
										DateUtil.StrToDate("2018-01-15T18:00:00", "yyyy-MM-dd HH:mm:ss"), 
										null,
										"UNIDADE 113",
										"BLOCO A",
										"Salao de festas Bloco A"));
		} catch (Exception e) {
			return new ResponseEntity<Object>(new CustomErrorType("Erro Exception " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
		return new ResponseEntity<List<ReservaDto>>(eventos, HttpStatus.OK);
	}
	
	@GetMapping(value="/{dataIni}/{dataFim}")
	public ResponseEntity<?> getReservas(@PathVariable("dataIni") String dataIni, @PathVariable("dataFim") String dataFim) {
		
		List<ReservaDto> eventos = new ArrayList<ReservaDto>();
		try {
			
			Date dtIni = DateUtil.StrToDate(dataIni, "yyyyMMdd");
			Date dtFim = DateUtil.StrToDate(dataFim, "yyyyMMdd");
			
			eventos = reservaService.findByDateIniAndDateFim(dtIni, dtFim);
			
			return new ResponseEntity<List<ReservaDto>>(eventos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(new CustomErrorType("Erro Exception " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(value="/{unidadeId}")
	public ResponseEntity<?> getReservas(@PathVariable("unidadeId") Long unidadeId) {
		
		List<ReservaDto> eventos = new ArrayList<ReservaDto>();
		try {					
			
			eventos = reservaService.findByUnidadeId(unidadeId);
			
			return new ResponseEntity<List<ReservaDto>>(eventos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(new CustomErrorType("Erro Exception " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(value="/espaco/{espacoComunId}")
	public ResponseEntity<?> getReservasEspacoComun(@PathVariable("espacoComunId") Long espacoComunId) {
		
		List<ReservaDto> eventos = new ArrayList<ReservaDto>();
		try {					
			
			eventos = reservaService.findByEspacoComunId(espacoComunId);
			
			return new ResponseEntity<List<ReservaDto>>(eventos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(new CustomErrorType("Erro Exception " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}