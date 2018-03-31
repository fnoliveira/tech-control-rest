package br.com.af.techcontrol.rest.service;

import br.com.af.techcontrol.rest.entity.condominio.Condominio;
import br.com.af.techcontrol.rest.service.base.CrudService;

public interface CondominioService extends CrudService<Condominio, Long> {

	Condominio findByCNPJ(String cpf_cnpj);

}