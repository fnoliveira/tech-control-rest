package br.com.af.techcontrol.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.af.techcontrol.rest.entity.funcionario.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

	List<Administrador> findByFuncionarioPessoaNome(String nome);

	Administrador findByFuncionarioPessoaCpfOuCnpj(String cpfOuCnpj);

}
