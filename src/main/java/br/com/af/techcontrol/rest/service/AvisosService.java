package br.com.af.techcontrol.rest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.dto.AvisosDto;
import br.com.af.techcontrol.rest.entity.condominio.Avisos;
import br.com.af.techcontrol.rest.service.base.CrudService;

@Service
public interface AvisosService extends CrudService<Avisos, Long>{
	
	public Avisos saveDto(AvisosDto avisosDto);
		
	public List<Avisos> findByCondominioId(Long condominioId);
	
	public List<Avisos> findByIsFixo(Boolean isFixo, Long condominioId);
	
	public List<Avisos> findByStartAndEnd(LocalDateTime now, Long condominioId);

}
