package br.com.af.techcontrol.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.controller.base.AbstractController;
import br.com.af.techcontrol.rest.dto.AvisosDto;
import br.com.af.techcontrol.rest.entity.condominio.Avisos;
import br.com.af.techcontrol.rest.entity.condominio.Condominio;
import br.com.af.techcontrol.rest.service.AvisosService;
import br.com.af.techcontrol.rest.service.CondominioService;

@RestController
@RequestMapping("/avisos")
public class AvisosController extends AbstractController<Avisos, Long> {

	@Autowired
	AvisosService avisosService;

	@Autowired
	CondominioService condominioService;

	public AvisosController(AvisosService service) {
		super(service);
	}

	@GetMapping(value = "/condominio/{condominioId}")
	public ResponseEntity<List<Avisos>> retrieveAvisos(@PathVariable("condominioId") Long condominioId) {

		List<Avisos> avisos = avisosService.findByCondominioId(condominioId);

		if (avisos == null) {
			return new ResponseEntity<List<Avisos>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Avisos>>(avisos, new HttpHeaders(), HttpStatus.OK);

	}

	@PostMapping(value = "/condominio/{condominioId}")
	public ResponseEntity<Avisos> saveAvisos(@PathVariable("condominioId") Long condominioId,
			@RequestBody AvisosDto avisosDto) {

		Condominio condominio = condominioService.obtemPorId(condominioId);
		List<Avisos> avisos = avisosService.findByCondominioId(condominio.getId());

		if (avisosDto == null) {
			return new ResponseEntity<Avisos>(HttpStatus.NOT_FOUND);
		}

		Avisos aviso = avisosService.saveDto(avisosDto);
		avisos.add(aviso);
		condominio.setAvisos(avisos);
		condominioService.salvar(condominio);

		return new ResponseEntity<Avisos>(aviso, new HttpHeaders(), HttpStatus.CREATED);

	}

}
