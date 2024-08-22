package com.example.fhceegovfsra.controllers;

import com.example.fhceegovfsra.objects.TipoDTO;
import com.example.fhceegovfsra.services.TipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class TipoController {

  private final TipoService tipoService;

  public TipoController(TipoService tipoService) {
    this.tipoService = tipoService;
  }

  @GetMapping("/tipos")
  public ResponseEntity<List<TipoDTO>> listar() {
    try {
      return new ResponseEntity<>(this.tipoService.listar(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/tipo")
  public ResponseEntity<TipoDTO> agregarTipo(@RequestBody TipoDTO tipoDTO) {
    try {
      return new ResponseEntity<>(this.tipoService.agregarTipo(tipoDTO), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
