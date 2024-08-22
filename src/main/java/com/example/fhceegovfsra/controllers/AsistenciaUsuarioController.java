package com.example.fhceegovfsra.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhceegovfsra.objects.AsistenciaUsuarioDTO;
import com.example.fhceegovfsra.services.AsistenciaUsuarioService;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class AsistenciaUsuarioController {

  private final AsistenciaUsuarioService asistenciaUsuarioService;

  public AsistenciaUsuarioController(AsistenciaUsuarioService asistenciaUsuarioService) {
    this.asistenciaUsuarioService = asistenciaUsuarioService;
  }

  @GetMapping("/asistencia-usuarios")
  public ResponseEntity<List<AsistenciaUsuarioDTO>> listar() {
    try {
      return new ResponseEntity<>(this.asistenciaUsuarioService.listar(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/asistencia-usuario")
  public ResponseEntity<AsistenciaUsuarioDTO> agregarAsistenciaUsuario(
      @RequestBody AsistenciaUsuarioDTO asistenciaUsuarioDTO) {
    try {
      return new ResponseEntity<>(this.asistenciaUsuarioService.agregarAsistenciaUsuario(asistenciaUsuarioDTO),
          HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
