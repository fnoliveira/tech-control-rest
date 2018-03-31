package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.af.techcontrol.rest.entity.base.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
