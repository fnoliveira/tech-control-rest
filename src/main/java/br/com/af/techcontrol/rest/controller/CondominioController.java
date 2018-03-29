package br.com.af.techcontrol.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.controller.base.AbstractController;
import br.com.af.techcontrol.rest.dto.CondominioListDto;
import br.com.af.techcontrol.rest.entity.condominio.Condominio;
import br.com.af.techcontrol.rest.service.CondominioService;

@RestController
@RequestMapping("/condominio")
public class CondominioController extends AbstractController<Condominio, Long> {

	@Autowired
	CondominioService condominioService;

	@Autowired
	public CondominioController(CondominioService condominioService) {
		super(condominioService);
	}

	@GetMapping("/pageable")
	public ResponseEntity<?> list(Pageable pageable) {
		Page<CondominioListDto> list = null;
		list = condominioService.pesquisarTodosProjection(pageable);
		return new ResponseEntity<Page<CondominioListDto>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<?> list() {
		List<CondominioListDto> list = null;
		list = condominioService.pesquisarTodosProjection();
		return new ResponseEntity<List<CondominioListDto>>(list, new HttpHeaders(), HttpStatus.OK);
	}

}