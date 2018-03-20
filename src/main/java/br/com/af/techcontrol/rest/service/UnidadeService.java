package br.com.af.techcontrol.rest.service;

import java.util.List;

import br.com.af.techcontrol.rest.entity.condominio.Unidade;
import br.com.af.techcontrol.rest.service.base.CrudService;

public interface UnidadeService extends CrudService<Unidade, Long>{

	List<Unidade> findByBlocoId(Long blocoId);

}