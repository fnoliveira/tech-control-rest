package br.com.af.techcontrol.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.entity.condominio.Administrador;
import br.com.af.techcontrol.rest.service.AdministradorService;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	AdministradorService administradorService;

	@PostMapping
	public Administrador createAdministrador(@Valid @RequestBody Administrador administrador) {
		return administradorService.save(administrador);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Administrador> getAdministradorById(@PathVariable(value = "id") Long administradorId) {
		Administrador administrador = administradorService.findOne(administradorId);
		if (administrador == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(administrador);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Administrador> updateAdministrador(@PathVariable(value = "id") Long administradorId,@Valid @RequestBody Administrador administradorDetails) {
		
		Administrador administrador = administradorService.findOne(administradorId);
		if (administrador == null) {
			return ResponseEntity.notFound().build();
		}

		Administrador updatedAdministrador = administradorService.save(administrador);
		return ResponseEntity.ok(updatedAdministrador);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Administrador> deleteAdministrador(@PathVariable(value = "id") Long administradorId) {
		
		Administrador administrador = administradorService.findOne(administradorId);
		
		if (administrador == null) {
			return ResponseEntity.notFound().build();
		}

		administradorService.delete(administrador);
		return ResponseEntity.ok().build();
	}
}
