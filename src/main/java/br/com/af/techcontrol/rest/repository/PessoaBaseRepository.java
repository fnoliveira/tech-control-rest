package br.com.af.techcontrol.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.af.techcontrol.rest.entity.base.Pessoa;

@NoRepositoryBean
public interface PessoaBaseRepository<T extends Pessoa> extends JpaRepository<T, Long> {

	public T findByNome(String nome);
}
