package br.com.af.techcontrol.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.dto.AdministradorInfo;
import br.com.af.techcontrol.rest.response.ApiStatusResponse;
import br.com.af.techcontrol.rest.response.Response;
import br.com.af.techcontrol.rest.service.AdministradorService;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	AdministradorService administradorService;

	@GetMapping(value = "/{nome}")
	public ResponseEntity<Response<AdministradorInfo>> retrieveUserInfo(@PathVariable("nome") String nome) {

		AdministradorInfo admin = administradorService.findByNameProjection(nome);

		if (admin == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<AdministradorInfo>(
					new ApiStatusResponse(HttpStatus.NOT_FOUND.value(), 4041, "Administrador with nome " + nome + " not found")));
		}

		return ResponseEntity.ok(new Response<AdministradorInfo>(admin, new ApiStatusResponse(HttpStatus.OK.value(), 2001,"Sucesso")));
	}

}
