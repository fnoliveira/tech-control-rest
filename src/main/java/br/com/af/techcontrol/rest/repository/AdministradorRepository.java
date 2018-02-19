package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.entity.condominio.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long>{

	public Administrador findByPessoaId(Long id);
	
}
