package br.com.af.techcontrol.rest.controller.base;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.af.techcontrol.rest.service.base.CrudService;

public abstract class AbstractController<E, PK extends Serializable> {

    protected CrudService<E, PK> service;

    public AbstractController(CrudService<E, PK> service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> get(@PathVariable PK id) {
        E entity = null;
        entity = service.obtemPorId(id);
        if (entity == null) {
            return new ResponseEntity<E>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<E>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> list(Pageable pageable) {
        Page<E> list = null;
        list = service.pesquisarTodos(pageable);
        return new ResponseEntity<Page<E>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<E> create(@RequestBody E e) {
        E entity = service.salvarComRetorno(e);
        return new ResponseEntity<E>(entity, new HttpHeaders(),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<E> remove(@PathVariable PK id) {
        E entity = service.obtemPorId(id);
        if (entity == null) {
            return new ResponseEntity<E>(HttpStatus.NOT_FOUND);
        }
        service.excluirPorId(id);
        return new ResponseEntity<E>(HttpStatus.NO_CONTENT);
    }


    @PutMapping
    public ResponseEntity<E> update(@RequestBody E e) {
        E entity = service.alterar(e);
        return new ResponseEntity<E>(entity, new HttpHeaders(), HttpStatus.OK);
    }
}

