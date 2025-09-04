package com.fhce.sra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.sra.dto.ambienteDtoRequest;
import com.fhce.sra.dto.ambienteDtoResponse;
import com.fhce.sra.service.ambienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fhce-egovf-sra/ambiente")
@RequiredArgsConstructor
public class ambienteController {
	
    private final ambienteService ambienteService;

    @GetMapping("/getListaAmbiente")
    public ResponseEntity<List<ambienteDtoResponse>> getListaAmbiente() {
        try {
			return new ResponseEntity<>(this.ambienteService.getListaAmbiente(),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @PostMapping("/addAmbiente")
    public ResponseEntity<ambienteDtoResponse> addAmbiente(@RequestBody ambienteDtoRequest ambienteDtoRequest) {
        try {
			return new ResponseEntity<>(this.ambienteService.addAmbiente(ambienteDtoRequest),HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @PutMapping("/updateAmbiente")
    public ResponseEntity<ambienteDtoResponse> updateAmbiente(@RequestBody ambienteDtoResponse ambienteDtoResponse) {
        try {
			return new ResponseEntity<>(this.ambienteService.updateAmbiente(ambienteDtoResponse),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
