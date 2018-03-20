package br.com.af.techcontrol.rest.service;

import java.time.LocalDateTime;

import br.com.af.techcontrol.rest.entity.condominio.Reserva;
import br.com.af.techcontrol.rest.service.base.CrudService;

public interface ReservaService extends CrudService<Reserva, Long> {

	boolean existeReservaByData(LocalDateTime start, Long espacoComumId);

}