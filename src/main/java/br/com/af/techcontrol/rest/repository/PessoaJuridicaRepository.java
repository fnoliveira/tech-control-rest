package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.entity.base.PessoaJuridica;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

	public PessoaJuridica findByNome(String nome);

	public PessoaJuridica findByRazaoSocial(String razaosocial);

	public PessoaJuridica findByCnpj(String cnpj);
}
