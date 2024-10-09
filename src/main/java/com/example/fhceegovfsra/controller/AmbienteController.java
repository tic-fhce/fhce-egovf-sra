package com.example.fhceegovfsra.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhceegovfsra.object.ambiente.AmbienteRequestDTO;
import com.example.fhceegovfsra.object.ambiente.AmbienteResponseDTO;
import com.example.fhceegovfsra.service.impl.AmbienteServiceImpl;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class AmbienteController {

  private final AmbienteServiceImpl ambienteService;

  public AmbienteController(AmbienteServiceImpl ambienteService) {
    this.ambienteService = ambienteService;
  }

  @GetMapping("/ambientes")
  public ResponseEntity<List<AmbienteResponseDTO>> listar() {
    try {
      return new ResponseEntity<>(this.ambienteService.listar(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/ambiente")
  public ResponseEntity<AmbienteResponseDTO> agregarAmbiente(@RequestBody AmbienteRequestDTO ambienteDTO) {
    try {
      return new ResponseEntity<>(this.ambienteService.agregarAmbiente(ambienteDTO), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
