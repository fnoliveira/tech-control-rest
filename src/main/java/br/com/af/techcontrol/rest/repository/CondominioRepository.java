package br.com.af.techcontrol.rest.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.af.techcontrol.rest.dto.CondominioListDto;
import br.com.af.techcontrol.rest.entity.condominio.Condominio;

public interface CondominioRepository extends JpaRepository<Condominio, Long> {

	Condominio findByPessoaCpfOuCnpj(String cpf_cnpj);
	
	@Query("SELECT c.pessoa.nome as nome, c.id as condominioId, c.isEnable as isEnable , c.finalidade as finalidade, c.pessoa.cpfOuCnpj as cpfOuCnpj FROM Condominio c ")
	Page<CondominioListDto> pesquisarTodosProjection(Pageable pageable);

	@Query("SELECT c.pessoa.nome as nome, c.id as condominioId, c.isEnable as isEnable , c.finalidade as finalidade, c.pessoa.cpfOuCnpj as cpfOuCnpj FROM Condominio c ")
	List<CondominioListDto> pesquisarTodosProjection();
	

}
