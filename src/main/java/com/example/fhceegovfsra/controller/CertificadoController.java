package com.example.fhceegovfsra.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhceegovfsra.object.certificado.CertificadoRequestDTO;
import com.example.fhceegovfsra.object.certificado.CertificadoResponseDTO;
import com.example.fhceegovfsra.service.impl.CertificadoServiceImpl;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class CertificadoController {

  private final CertificadoServiceImpl certificadoService;

  public CertificadoController(CertificadoServiceImpl certificadoService) {
    this.certificadoService = certificadoService;
  }

  @GetMapping("/certificados")
  public ResponseEntity<List<CertificadoResponseDTO>> listar() {
    try {
      return new ResponseEntity<>(this.certificadoService.listar(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/certificado")
  public ResponseEntity<CertificadoResponseDTO> agregarCertificado(@RequestBody CertificadoRequestDTO certificadoDTO) {
    try {
      return new ResponseEntity<>(this.certificadoService.agregarCertificado(certificadoDTO), HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
