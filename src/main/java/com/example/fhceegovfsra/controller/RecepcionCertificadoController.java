package com.example.fhceegovfsra.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhceegovfsra.object.recepcion_certificado.RecepcionCertificadoRequestDTO;
import com.example.fhceegovfsra.object.recepcion_certificado.RecepcionCertificadoResponseDTO;
import com.example.fhceegovfsra.service.impl.RecepcionCertificadoServiceImpl;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class RecepcionCertificadoController {

  private final RecepcionCertificadoServiceImpl recepcionCertificadoService;

  public RecepcionCertificadoController(RecepcionCertificadoServiceImpl recepcionCertificadoService) {
    this.recepcionCertificadoService = recepcionCertificadoService;
  }

  @PostMapping("/recepcion-certificado")
  public ResponseEntity<RecepcionCertificadoResponseDTO> agregarRecepcionCertificado(
      @RequestBody RecepcionCertificadoRequestDTO recepcionCertificadoDTO) {
    try {
      return new ResponseEntity<>(this.recepcionCertificadoService.agregarRecepcionCertificado(recepcionCertificadoDTO),
          HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/recepcion-certificados")
  public ResponseEntity<List<RecepcionCertificadoResponseDTO>> listar() {
    try {
      return new ResponseEntity<>(this.recepcionCertificadoService.listar(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/recepcion-certificado")
  public ResponseEntity<List<RecepcionCertificadoResponseDTO>> listar(@RequestParam Long cif) {
    try {
      return new ResponseEntity<>(this.recepcionCertificadoService.listar(cif), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
