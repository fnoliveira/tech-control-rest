package br.com.af.techcontrol.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.entity.base.PessoaFisica;
import br.com.af.techcontrol.rest.entity.condominio.Administrador;
import br.com.af.techcontrol.rest.service.AdministradorService;

@RestController
@RequestMapping("/administracao")
public class AdministracaoController {

	@Autowired
	AdministradorService administracaoService;
	
	
	@GetMapping
	public ResponseEntity<List<Administrador>> getReserva() {

		List<Administrador> administracoes = new ArrayList<Administrador>();
		
		administracoes =administracaoService.findAll();

		return new ResponseEntity<List<Administrador>>(administracoes, HttpStatus.OK);
	}
}
