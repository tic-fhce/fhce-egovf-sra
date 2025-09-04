package com.fhce.sra.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.sra.dto.servicioDtoRequest;
import com.fhce.sra.dto.servicioDtoResponse;
import com.fhce.sra.service.servicioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fhce-egovf-sra/servicio")
@RequiredArgsConstructor
public class servicioController {
	
	private final servicioService servicioService;
	
    @GetMapping("/getListaServicio")
    public ResponseEntity<List<servicioDtoResponse>> getListaServicio(@RequestParam (value="idambiente") Long idAmbiente) {
        try {
			return new ResponseEntity<>(this.servicioService.getListaServicio(idAmbiente),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/addServicio")
    public ResponseEntity<servicioDtoResponse> addServicio(@RequestBody servicioDtoRequest servicioDtoRequest) {
        try {
			return new ResponseEntity<>(this.servicioService.addServicio(servicioDtoRequest),HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
