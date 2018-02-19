package br.com.af.techcontrol.rest.repository;

import br.com.af.techcontrol.rest.entity.base.PessoaJuridica;

public interface PessoaJuridicaRepository extends PessoaBaseRepository<PessoaJuridica> {

	public PessoaJuridica findByRazaoSocial(String razaosocial);

	public PessoaJuridica findByCnpj(String cnpj);
}
