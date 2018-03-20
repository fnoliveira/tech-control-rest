package br.com.af.techcontrol.rest.service;

import br.com.af.techcontrol.rest.entity.base.Endereco;
import br.com.af.techcontrol.rest.service.base.CrudService;

public interface EnderecoService extends CrudService<Endereco, Long> {

	Endereco createEndereco(String cep, String logradouro, String numero, String complemento, String bairro,
			String cidade, String uf);

}