package br.com.af.techcontrol.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.model.Administracao;
import br.com.af.techcontrol.rest.service.AdministracaoService;

@RestController
@RequestMapping("/administracao")
public class AdministracaoController {

	@Autowired
	AdministracaoService administracaoService;
	
	
	@GetMapping
	public ResponseEntity<List<Administracao>> getReserva() {

		List<Administracao> administracoes = new ArrayList<Administracao>();
		
		
		
		administracoes =administracaoService.findAll();

		return new ResponseEntity<List<Administracao>>(administracoes, HttpStatus.OK);
	}
}
