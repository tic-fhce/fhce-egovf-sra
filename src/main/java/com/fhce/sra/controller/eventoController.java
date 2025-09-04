package com.fhce.sra.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.sra.dto.eventoDtoObj;
import com.fhce.sra.dto.eventoDtoRequest;
import com.fhce.sra.dto.eventoDtoResponse;
import com.fhce.sra.service.eventoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fhce-egovf-sra/evento")
@RequiredArgsConstructor
public class eventoController {
	
	private final eventoService eventoService;
	@GetMapping("/getListaEventos")
    public ResponseEntity<List<eventoDtoObj>> getListaEventos() {
        try {
			return new ResponseEntity<>(this.eventoService.getListaEventos(),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@GetMapping("/getListaEventoAmbiente")
    public ResponseEntity<List<eventoDtoObj>> getListaEventoAmbiente(@RequestParam (value="gestion") int gestion,@RequestParam (value="idAmbiente") Long idAmbiente) {
        try {
			return new ResponseEntity<>(this.eventoService.getListaEventoAmbiente(gestion,idAmbiente),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@PostMapping("/addEvento")
    public ResponseEntity<eventoDtoResponse> addEvento(@RequestBody eventoDtoRequest eventoDtoRequest) {
        try {
			return new ResponseEntity<>(this.eventoService.addEvento(eventoDtoRequest),HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PutMapping("/updateEvento")
    public ResponseEntity<eventoDtoResponse> updateEvento(@RequestBody eventoDtoResponse eventoDtoResponse) {
        try {
			return new ResponseEntity<>(this.eventoService.updateEvento(eventoDtoResponse),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/getEvento")
    public ResponseEntity<eventoDtoObj> getEvento(@RequestParam (value="idEvento") Long idEvento) {
        try {
			return new ResponseEntity<>(this.eventoService.getEvento(idEvento),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    @GetMapping("/getEventoUnidad")
    public ResponseEntity<List<eventoDtoObj>> getEventoUnidad(@RequestParam (value="unidad") String unidad,@RequestParam (value="fecha") String fecha) {
        try {
			return new ResponseEntity<>(this.eventoService.getEventoUnidad(unidad,fecha),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
