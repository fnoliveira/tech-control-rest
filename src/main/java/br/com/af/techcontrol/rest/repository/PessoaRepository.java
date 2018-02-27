package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.entity.base.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{


}
