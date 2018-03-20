package br.com.af.techcontrol.rest.service;

import java.util.List;

import br.com.af.techcontrol.rest.entity.condominio.EspacoComum;
import br.com.af.techcontrol.rest.service.base.CrudService;

public interface EspacoComumService extends CrudService<EspacoComum, Long> {

	EspacoComum findByNome(String nome);

	List<EspacoComum> findByCondominio(Long condominioId);

}