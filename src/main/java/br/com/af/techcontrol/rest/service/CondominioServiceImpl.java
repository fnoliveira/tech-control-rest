package br.com.af.techcontrol.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.dto.CondominioListDto;
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
	
	@Override
	@Transactional(readOnly = true)
	public Page<CondominioListDto> pesquisarTodosProjection(Pageable pageable){
		return condominioRepository.pesquisarTodosProjection(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<CondominioListDto> pesquisarTodosProjection(){
		return condominioRepository.pesquisarTodosProjection();
	}
	
}
