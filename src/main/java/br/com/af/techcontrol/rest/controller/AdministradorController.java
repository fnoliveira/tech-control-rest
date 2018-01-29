package br.com.af.techcontrol.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.entity.condominio.Administrador;
import br.com.af.techcontrol.rest.response.Response;
import br.com.af.techcontrol.rest.service.AdministradorService;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	AdministradorService administradorService;

	@GetMapping
	public ResponseEntity<Response<List<Administrador>>> retrieveAll() {
		return ResponseEntity.ok(new Response<List<Administrador>>(this.administradorService.findAll()));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Administrador>> listarPorId(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(new Response<Administrador>(this.administradorService.findOne(id)));
	}

	@PostMapping
	public ResponseEntity<Response<Administrador>> cadastrar(@Valid @RequestBody Administrador administrador,
			BindingResult result) {

		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Administrador>(erros));
		}

		return ResponseEntity.ok(new Response<Administrador>(this.administradorService.save(administrador)));
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Administrador>> atualizar(@PathVariable(name = "id") Long id,
			@Valid @RequestBody Administrador administrador, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Administrador>(erros));
		}

		administrador.setId(id);
		return ResponseEntity.ok(new Response<Administrador>(this.administradorService.save(administrador)));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") Long id) {
		this.administradorService.delete(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}

}
