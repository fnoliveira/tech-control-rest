package br.com.af.techcontrol.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.condominio.EspacoComum;
import br.com.af.techcontrol.rest.repository.EspacoComumRepository;
import br.com.af.techcontrol.rest.service.base.AbstractService;

@Service
@Transactional
public class EspacoComumServiceImpl extends AbstractService<EspacoComum, Long> implements EspacoComumService {

	@Autowired
	EspacoComumRepository repository;

	@Override
	public EspacoComum findByNome(String nome) {
		return repository.findByNome(nome);
	}

	@Override
	public List<EspacoComum> findByCondominio(Long condominioId) {
		return repository.findByCondominio(condominioId);
	}

}
