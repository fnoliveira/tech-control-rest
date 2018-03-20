package br.com.af.techcontrol.rest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.af.techcontrol.rest.dto.AvisosDto;
import br.com.af.techcontrol.rest.entity.condominio.Avisos;
import br.com.af.techcontrol.rest.repository.AvisosRepository;
import br.com.af.techcontrol.rest.service.base.AbstractService;

@Service
public class AvisosServiceImpl extends AbstractService<Avisos, Long> implements AvisosService{
	
	@Autowired
	AvisosRepository repository;
	
	@Transactional
	public Avisos saveDto(AvisosDto avisosDto) {
		Avisos avisos = new Avisos(avisosDto.getDestinatario(),
									avisosDto.getTitulo(),
									avisosDto.getAviso(),
									avisosDto.getAnexo(),
									avisosDto.getIsUrgente(),
									avisosDto.getIsFixo(),
									avisosDto.getIsEnable(), 
									avisosDto.getStart(),
									avisosDto.getEnd()
									);
		
		
		return repository.save(avisos);
	}

	@Transactional
	public List<Avisos> findByCondominioId(Long condominioId){
		return repository.findByCondominioId(condominioId);
	}
	
	@Transactional
	public List<Avisos> findByIsFixo(Boolean isFixo, Long condominioId){
		return repository.findByIsFixo(isFixo, condominioId);
	}
	
	@Transactional
	public List<Avisos> findByStartAndEnd(LocalDateTime now, Long condominioId){
		return repository.findByStartAndEnd(now, condominioId);
	}	

}
