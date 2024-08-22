package com.example.fhceegovfsra.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhceegovfsra.objects.CertificadoDTO;
import com.example.fhceegovfsra.services.CertificadoService;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class CertificadoController {

  private final CertificadoService certificadoService;

  public CertificadoController(CertificadoService certificadoService) {
    this.certificadoService = certificadoService;
  }

  @GetMapping("/certificados")
  public ResponseEntity<List<CertificadoDTO>> listar() {
    try {
      return new ResponseEntity<>(this.certificadoService.listar(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/certificado")
  public ResponseEntity<CertificadoDTO> agregarCertificado(@RequestBody CertificadoDTO certificadoDTO) {
    try {
      return new ResponseEntity<>(this.certificadoService.agregarCertificado(certificadoDTO), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
