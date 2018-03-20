package br.com.af.techcontrol.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.Telefone;
import br.com.af.techcontrol.rest.repository.TelefoneRepository;
import br.com.af.techcontrol.rest.service.base.AbstractService;

@Service
public class TelefoneServiceImpl extends AbstractService<Telefone, Long> implements TelefoneService {

	@Autowired
	TelefoneRepository repository;

}
