package br.com.af.techcontrol.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.entity.funcionario.Administrador;
import br.com.af.techcontrol.rest.response.ApiStatusResponse;
import br.com.af.techcontrol.rest.response.Response;
import br.com.af.techcontrol.rest.service.AdministradorService;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	AdministradorService administradorService;

	@GetMapping(value = "/{nome}")
	public ResponseEntity<Response<List<Administrador>>> retrieveUserInfo(@PathVariable("nome") String nome) {

		List<Administrador> admin = administradorService.findByName(nome);

		if (admin == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<List<Administrador>>(
					new ApiStatusResponse(HttpStatus.NOT_FOUND.value(), 4041, "Administrador with nome " + nome + " not found")));
		}

		return ResponseEntity.ok(new Response<List<Administrador>>(admin, new ApiStatusResponse(HttpStatus.OK.value(), 2001,"Sucesso")));
	}

}
