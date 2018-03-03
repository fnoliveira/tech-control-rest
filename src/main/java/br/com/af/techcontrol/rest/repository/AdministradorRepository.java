package br.com.af.techcontrol.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.dto.AdministradorInfo;
import br.com.af.techcontrol.rest.entity.funcionario.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

	List<AdministradorInfo> findByFuncionarioPessoaNome(String nome);
	
	Administrador findByFuncionarioPessoaCpfOuCnpj(String cpfOuCnpj);

}
