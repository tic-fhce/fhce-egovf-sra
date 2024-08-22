package com.example.fhceegovfsra.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhceegovfsra.objects.EventoDTO;
import com.example.fhceegovfsra.services.EventoService;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class EventoController {

  private final EventoService eventoService;

  public EventoController(EventoService eventoService) {
    this.eventoService = eventoService;
  }

  @GetMapping("/eventos")
  public ResponseEntity<List<EventoDTO>> listar() {
    try {
      return new ResponseEntity<>(this.eventoService.listar(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/evento")
  public ResponseEntity<EventoDTO> agregarEvento(@RequestBody EventoDTO eventoDTO) {
    try {
      return new ResponseEntity<>(this.eventoService.agregarEvento(eventoDTO), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
