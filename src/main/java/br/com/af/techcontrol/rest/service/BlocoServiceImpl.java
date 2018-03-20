package br.com.af.techcontrol.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.condominio.Bloco;
import br.com.af.techcontrol.rest.repository.BlocoRepository;
import br.com.af.techcontrol.rest.service.base.AbstractService;

@Service
public class BlocoServiceImpl extends AbstractService<Bloco, Long> implements BlocoService {

	@Autowired
	BlocoRepository repository;

}
