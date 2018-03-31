package br.com.af.techcontrol.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.condominio.Condominio;
import br.com.af.techcontrol.rest.repository.CondominioRepository;
import br.com.af.techcontrol.rest.service.base.AbstractService;

@Service
public class CondominioServiceImpl extends AbstractService<Condominio, Long> implements CondominioService {

	@Autowired
	CondominioRepository condominioRepository;

	@Override
	@Transactional(readOnly = true)
	public Condominio findByCNPJ(String cpf_cnpj) {
		return condominioRepository.findByPessoaCpfOuCnpj(cpf_cnpj);
	}

}
