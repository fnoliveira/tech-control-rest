package br.com.af.techcontrol.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.af.techcontrol.rest.dto.AvisosDto;
import br.com.af.techcontrol.rest.entity.condominio.Avisos;
import br.com.af.techcontrol.rest.entity.condominio.Condominio;
import br.com.af.techcontrol.rest.response.ApiStatusResponse;
import br.com.af.techcontrol.rest.response.Response;
import br.com.af.techcontrol.rest.service.AvisosService;
import br.com.af.techcontrol.rest.service.CondominioService;

@RestController
@RequestMapping("/avisos")
public class AvisosController {
	
	@Autowired
	AvisosService avisosService;
	
	@Autowired
	CondominioService condominioService;
	
	@GetMapping(value = "/condominio/{condominioId}")
	public ResponseEntity<Response<List<Avisos>>> retrieveAvisos(@PathVariable("condominioId") Long condominioId) {

		List<Avisos> avisos = avisosService.findByCondominioId(condominioId);

		if (avisos == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<List<Avisos>>(
					new ApiStatusResponse(HttpStatus.NOT_FOUND.value(), 4041, "Avisos Condominio with ID " + condominioId + " not found")));
		}

		return ResponseEntity.ok(new Response<List<Avisos>>(avisos, new ApiStatusResponse(HttpStatus.OK.value(), 2001,"Sucesso")));
	}
	
	@PostMapping(value = "/condominio/{condominioId}")
	public ResponseEntity<Response<Avisos>> saveAvisos (@PathVariable("condominioId") Long condominioId, @RequestBody AvisosDto avisosDto){
		
		try {
			Condominio condominio = condominioService.findById(condominioId);
			List<Avisos> avisos = avisosService.findByCondominioId(condominio.getId());
			
			if(avisosDto == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<Avisos>(
						new ApiStatusResponse(HttpStatus.NOT_FOUND.value(), 4041, "Avisos Condominio null")));
			}		
			
			Avisos aviso = avisosService.saveDto(avisosDto);
			avisos.add(aviso);
			condominio.setAvisos(avisos);
			condominioService.save(condominio);
			
			return ResponseEntity.ok(new Response<Avisos>(aviso, new ApiStatusResponse(HttpStatus.OK.value(), 2001,"Sucesso")));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<Avisos>(
					new ApiStatusResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), 5041, e.getMessage())));
		}
		
		
	}

}
