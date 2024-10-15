package com.example.fhceegovfsra.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhceegovfsra.object.evento.EventoCompleteDTO;
import com.example.fhceegovfsra.object.evento.EventoConfirmDTO;
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
      System.out.println(e);
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

  @GetMapping("/eventos-confirmados")
  public ResponseEntity<List<EventoResponseDTO>> listarConfirmados() {
    try {
      return new ResponseEntity<>(this.eventoService.listarConfirmados(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/eventos-pendientes")
  public ResponseEntity<List<EventoResponseDTO>> listarPendientes() {
    try {
      return new ResponseEntity<>(this.eventoService.listarPendientes(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PatchMapping("/evento-completar")
  public ResponseEntity<EventoResponseDTO> actualizar(@RequestBody EventoCompleteDTO eventoDTO) {
    try {
      return new ResponseEntity<>(this.eventoService.completarEvento(eventoDTO), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PatchMapping("/evento-confirmar")
  public ResponseEntity<EventoResponseDTO> confirmar(@RequestBody EventoConfirmDTO eventoDTO) {
    try {
      return new ResponseEntity<>(this.eventoService.confirmarEvento(eventoDTO), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/eventos-terminados")
  public ResponseEntity<List<EventoResponseDTO>> listarTerminados() {
    try {
      return new ResponseEntity<>(this.eventoService.listarTerminados(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
