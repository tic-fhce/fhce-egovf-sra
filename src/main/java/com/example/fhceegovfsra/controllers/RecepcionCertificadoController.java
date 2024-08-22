package com.example.fhceegovfsra.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhceegovfsra.objects.RecepcionCertificadoDTO;
import com.example.fhceegovfsra.services.RecepcionCertificadoService;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class RecepcionCertificadoController {

  private final RecepcionCertificadoService recepcionCertificadoService;

  public RecepcionCertificadoController(RecepcionCertificadoService recepcionCertificadoService) {
    this.recepcionCertificadoService = recepcionCertificadoService;
  }

  @GetMapping("/recepcion-certificados")
  public ResponseEntity<List<RecepcionCertificadoDTO>> listar() {
    try {
      return new ResponseEntity<>(this.recepcionCertificadoService.listar(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/recepcion-certificado")
  public ResponseEntity<RecepcionCertificadoDTO> agregarRecepcionCertificado(
      @RequestBody RecepcionCertificadoDTO recepcionCertificadoDTO) {
    try {
      return new ResponseEntity<>(this.recepcionCertificadoService.agregarRecepcionCertificado(recepcionCertificadoDTO),
          HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
