package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.entity.condomino.Condomino;

public interface CondominoRepository extends JpaRepository<Condomino, Long> {

	Condomino findByPessoaCpfOuCnpj(String cpf_cnpj);

}
