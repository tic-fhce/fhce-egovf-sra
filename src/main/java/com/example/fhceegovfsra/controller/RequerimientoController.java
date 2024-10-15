package com.example.fhceegovfsra.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhceegovfsra.object.requerimiento.RequerimientoRequestDTO;
import com.example.fhceegovfsra.object.requerimiento.RequerimientoResponseDTO;
import com.example.fhceegovfsra.service.impl.RequerimientoServiceImpl;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class RequerimientoController {

  private final RequerimientoServiceImpl requerimientoService;

  public RequerimientoController(RequerimientoServiceImpl requerimientoService) {
    this.requerimientoService = requerimientoService;
  }

  @GetMapping("/requerimientos")
  public ResponseEntity<List<RequerimientoResponseDTO>> listar() {
    try {
      return new ResponseEntity<>(this.requerimientoService.listar(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/requerimiento")
  public ResponseEntity<RequerimientoResponseDTO> agregarRequerimiento(
      @RequestBody RequerimientoRequestDTO requerimientoDTO) {
    try {
      return new ResponseEntity<>(this.requerimientoService.agregarRequerimiento(requerimientoDTO), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
