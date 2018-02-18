package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.entity.base.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
