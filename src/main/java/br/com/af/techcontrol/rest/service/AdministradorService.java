package br.com.af.techcontrol.rest.service;

import java.util.List;

import br.com.af.techcontrol.rest.entity.funcionario.Administrador;
import br.com.af.techcontrol.rest.service.base.CrudService;

public interface AdministradorService extends CrudService<Administrador, Long>{

	public Administrador findByCPFCNPJ(String cpfOuCnpj);

	public List<Administrador> findByName(String nome);

}
