package com.example.fhceegovfsra.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhceegovfsra.objects.RequerimientoDTO;
import com.example.fhceegovfsra.services.RequerimientoService;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class RequerimientoController {
  private final RequerimientoService requerimientoService;

  public RequerimientoController(RequerimientoService requerimientoService) {
    this.requerimientoService = requerimientoService;
  }

  @GetMapping("/requerimientos")
  public ResponseEntity<List<RequerimientoDTO>> listar() {
    try {
      return new ResponseEntity<>(this.requerimientoService.listar(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/requerimiento")
  public ResponseEntity<RequerimientoDTO> agregarRequerimiento(@RequestBody RequerimientoDTO requerimientoDTO) {
    try {
      return new ResponseEntity<>(this.requerimientoService.agregarRequerimiento(requerimientoDTO), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
