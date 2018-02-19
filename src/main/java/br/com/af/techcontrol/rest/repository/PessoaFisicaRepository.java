package br.com.af.techcontrol.rest.repository;

import br.com.af.techcontrol.rest.entity.base.PessoaFisica;

public interface PessoaFisicaRepository extends PessoaBaseRepository<PessoaFisica> {

	public PessoaFisica findByCpf(String cpf);

}
