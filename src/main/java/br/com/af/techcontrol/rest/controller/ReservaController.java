package br.com.af.techcontrol.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.dto.ReservaDto;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@GetMapping
	public ResponseEntity<List<ReservaDto>> getReserva() {

		List<ReservaDto> eventos = new ArrayList<ReservaDto>();

		eventos.add(new ReservaDto(1, "Festa Apto 113", "Festa da Julia",false, "2018-01-15T13:00:00", "2018-01-15T18:00:00", null));
		return new ResponseEntity<List<ReservaDto>>(eventos, HttpStatus.OK);
	}

}