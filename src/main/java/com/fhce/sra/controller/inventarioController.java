package com.fhce.sra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.sra.dto.inventarioDtoRequest;
import com.fhce.sra.dto.inventarioDtoResponse;
import com.fhce.sra.service.inventarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fhce-egovf-sra/inventario")
@RequiredArgsConstructor
public class inventarioController {
	
	private final inventarioService inventarioService;

    @PostMapping("/addInventario")
    public ResponseEntity<inventarioDtoResponse> addInventario(@RequestBody inventarioDtoRequest inventarioDtoRequest) {
        try {
			return new ResponseEntity<>(this.inventarioService.addInventario(inventarioDtoRequest),HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
