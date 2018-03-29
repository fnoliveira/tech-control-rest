package br.com.af.techcontrol.rest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.af.techcontrol.rest.dto.CondominioListDto;
import br.com.af.techcontrol.rest.entity.condominio.Condominio;
import br.com.af.techcontrol.rest.service.base.CrudService;

public interface CondominioService extends CrudService<Condominio, Long>{

	Condominio findByCNPJ(String cpf_cnpj);

	Page<CondominioListDto> pesquisarTodosProjection(Pageable pageable);

	List<CondominioListDto> pesquisarTodosProjection();

}