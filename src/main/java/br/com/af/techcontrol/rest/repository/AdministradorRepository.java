package br.com.af.techcontrol.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.rest.dto.AdministradorInfo;
import br.com.af.techcontrol.rest.entity.condominio.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

	List<AdministradorInfo> findByPessoaNome(String nome);

}
