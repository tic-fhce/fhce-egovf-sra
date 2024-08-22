package com.example.fhceegovfsra.controllers;

import com.example.fhceegovfsra.objects.AmbienteDTO;
import com.example.fhceegovfsra.services.AmbienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class AmbienteController {

  private final AmbienteService ambienteService;

  public AmbienteController(AmbienteService ambienteService) {
    this.ambienteService = ambienteService;
  }

  @GetMapping("/ambientes")
  public ResponseEntity<List<AmbienteDTO>> listar() {
    try {
      return new ResponseEntity<>(this.ambienteService.listar(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/ambiente")
  public ResponseEntity<AmbienteDTO> agregarAmbiente(@RequestBody AmbienteDTO ambienteDTO) {
    try {
      return new ResponseEntity<>(this.ambienteService.agregarAmbiente(ambienteDTO), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
