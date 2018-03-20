package br.com.af.techcontrol.rest.service;

import br.com.af.techcontrol.rest.entity.condomino.Condomino;
import br.com.af.techcontrol.rest.service.base.CrudService;

public interface CondominoService extends CrudService<Condomino, Long> {

	Condomino findByCPFCNPJ(String cpf_cnpj);

}