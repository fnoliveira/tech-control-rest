package br.com.af.techcontrol.rest.service.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractService<E, PK extends Serializable> implements CrudService<E, PK> {

	@Autowired
	private JpaRepository<E, PK> repository;

	public JpaRepository<E, PK> getRepository() {
		return repository;
	}

	public void setRepository(JpaRepository<E, PK> repository) {
		this.repository = repository;
	}

	@Transactional
	public void salvar(E entity) {
		getRepository().save(entity);
	}

	@Transactional
	public List<E> salvarComRetorno(List<E> entity) {
		return getRepository().save(entity);
	}

	@Transactional
	public void salvar(List<E> entity) {
		getRepository().save(entity);
	}

	@Transactional
	public E salvarComRetorno(E entity) {
		return getRepository().save(entity);
	}

	@Transactional
	public E alterar(E entity) {
		return getRepository().save(entity);
	}

	@Transactional(readOnly = true)
	public E obtemPorId(PK primaryKey) {
		return getRepository().findOne(primaryKey);
	}

	@Transactional
	public void excluirPorId(PK primaryKey) {
		E entity = getRepository().findOne(primaryKey);
		if (entity == null) {
			System.out.println("Esse documento nao existe");
		}
		getRepository().delete(primaryKey);
	}

	@Transactional(readOnly = true)
	public Collection<E> pesquisarTodos() {
		return getRepository().findAll();
	}

	@Transactional(readOnly = true)
	public Page<E> pesquisarTodos(Pageable pageable) {
		return getRepository().findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Collection<E> listarTodos() {
		return getRepository().findAll();
	}

}
