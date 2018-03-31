package br.com.af.techcontrol.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.controller.base.AbstractController;
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

}