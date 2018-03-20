package br.com.af.techcontrol.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.entity.condomino.Condomino;
import br.com.af.techcontrol.rest.repository.CondominoRepository;
import br.com.af.techcontrol.rest.service.base.AbstractService;

@Service
public class CondominoServiceImpl extends AbstractService<Condomino, Long> implements CondominoService {

	@Autowired
	CondominoRepository condominoRepository;

	@Override
	@Transactional(readOnly = true)
	public Condomino findByCPFCNPJ(String cpf_cnpj) {
		return condominoRepository.findByPessoaCpfOuCnpj(cpf_cnpj);
	}
}
