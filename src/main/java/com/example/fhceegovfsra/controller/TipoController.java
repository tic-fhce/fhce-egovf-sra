package com.example.fhceegovfsra.controller;

import com.example.fhceegovfsra.object.tipo.TipoRequestDTO;
import com.example.fhceegovfsra.object.tipo.TipoResponseDTO;
import com.example.fhceegovfsra.service.impl.TipoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class TipoController {

  private final TipoServiceImpl tipoService;

  public TipoController(TipoServiceImpl tipoService) {
    this.tipoService = tipoService;
  }

  @GetMapping("/tipos")
  public ResponseEntity<List<TipoResponseDTO>> listar() {
    try {
      return new ResponseEntity<>(this.tipoService.listar(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/tipo")
  public ResponseEntity<TipoResponseDTO> agregarTipo(@RequestBody TipoRequestDTO tipoDTO) {
    try {
      return new ResponseEntity<>(this.tipoService.agregarTipo(tipoDTO), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
