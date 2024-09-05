package com.example.fhceegovfsra.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.fhceegovfsra.object.evento.EventoRequestDTO;
import com.example.fhceegovfsra.object.evento.EventoResponseDTO;
import com.example.fhceegovfsra.service.impl.EventoServiceImpl;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class EventoController {

  private final EventoServiceImpl eventoService;

  public EventoController(EventoServiceImpl eventoService) {
    this.eventoService = eventoService;
  }

  @PostMapping("/evento")
  public ResponseEntity<EventoResponseDTO> listar(@RequestBody EventoRequestDTO eventoDTO) {
    try {
      return new ResponseEntity<>(this.eventoService.agregarEvento(eventoDTO), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/eventos")
  public ResponseEntity<List<EventoResponseDTO>> listar() {
    try {
      return new ResponseEntity<>(this.eventoService.listar(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // @PostMapping("/evento/requerimientos")
  // public ResponseEntity<RequerimientosEventoResponse> agregarRequerimientos(
  // @RequestBody RequerimientosEventoResponse requerimientosEventoResponse) {
  // try {
  // return new
  // ResponseEntity<>(this.eventoService.agregarRequerimientos(requerimientosEventoResponse.getId_evento(),
  // requerimientosEventoResponse.getIds_requerimientos()), HttpStatus.CREATED);

  // } catch (Exception e) {
  // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  // }
  // }

}
