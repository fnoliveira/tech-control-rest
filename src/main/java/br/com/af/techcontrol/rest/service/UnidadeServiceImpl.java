package br.com.af.techcontrol.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.condominio.Unidade;
import br.com.af.techcontrol.rest.repository.UnidadeRepository;
import br.com.af.techcontrol.rest.service.base.AbstractService;

@Service
public class UnidadeServiceImpl extends AbstractService<Unidade, Long> implements UnidadeService {

	@Autowired
	UnidadeRepository repository;
	
	@Override
	@Transactional
	public List<Unidade> findByBlocoId(Long blocoId) {
		return repository.findByBlocoId(blocoId);
	}

}
