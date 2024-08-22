package com.example.fhceegovfsra.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhceegovfsra.objects.EventoRequerimientosDTO;
import com.example.fhceegovfsra.services.EventoRequerimientosService;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class EventoRequerimientosController {

  private final EventoRequerimientosService eventoRequerimientosService;

  public EventoRequerimientosController(EventoRequerimientosService eventoRequerimientosService) {
    this.eventoRequerimientosService = eventoRequerimientosService;
  }

  @PostMapping("/evento-requerimientos")
  public ResponseEntity<EventoRequerimientosDTO> agregarEventoRequerimiento(
      @RequestBody EventoRequerimientosDTO eventoRequerimientosDTO) {
    try {
      return new ResponseEntity<>(this.eventoRequerimientosService.agregarEventoRequerimiento(eventoRequerimientosDTO),
          HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/evento-requerimientos")
  public ResponseEntity<List<EventoRequerimientosDTO>> listar() {
    try {
      return new ResponseEntity<>(this.eventoRequerimientosService.listar(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
