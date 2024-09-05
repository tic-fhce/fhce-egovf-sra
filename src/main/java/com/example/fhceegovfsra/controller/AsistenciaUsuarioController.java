package com.example.fhceegovfsra.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhceegovfsra.object.asistencia_usuario.AsistenciaUsuarioRequestDTO;
import com.example.fhceegovfsra.object.asistencia_usuario.AsistenciaUsuarioResponseDTO;
import com.example.fhceegovfsra.service.impl.AsistenciaUsuarioServiceImpl;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class AsistenciaUsuarioController {

  private final AsistenciaUsuarioServiceImpl asistenciaUsuarioService;

  public AsistenciaUsuarioController(AsistenciaUsuarioServiceImpl asistenciaUsuarioService) {
    this.asistenciaUsuarioService = asistenciaUsuarioService;
  }

  @GetMapping("/asistencia-usuarios")
  public ResponseEntity<List<AsistenciaUsuarioResponseDTO>> listar() {
    try {
      return new ResponseEntity<>(this.asistenciaUsuarioService.listar(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/asistencia-usuario")
  public ResponseEntity<AsistenciaUsuarioResponseDTO> agregarAsistenciaUsuario(
      @RequestBody AsistenciaUsuarioRequestDTO asistenciaUsuarioDTO) {
    try {

      return new ResponseEntity<>(this.asistenciaUsuarioService.agregarAsistenciaUsuario(asistenciaUsuarioDTO),
          HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/asistencia-usuario")
  public ResponseEntity<List<AsistenciaUsuarioResponseDTO>> listar(@RequestParam Long cif) {
    try {
      return new ResponseEntity<>(this.asistenciaUsuarioService.listar(cif), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // @GetMapping("/asistencia-usuarios")
  // public ResponseEntity<List<AsistenciaUsuarioDTO>> listar() {
  // try {
  // return new ResponseEntity<>(this.asistenciaUsuarioService.listar(),
  // HttpStatus.OK);
  // } catch (Exception e) {
  // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  // }
  // }

  // @PostMapping("/asistencia-usuario")
  // public ResponseEntity<AsistenciaUsuarioDTO> agregarAsistenciaUsuario(
  // @RequestBody AsistenciaUsuarioDTO asistenciaUsuarioDTO) {
  // try {

  // return new
  // ResponseEntity<>(this.asistenciaUsuarioService.agregarAsistenciaUsuario(asistenciaUsuarioDTO),
  // HttpStatus.CREATED);
  // } catch (Exception e) {
  // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  // }
  // }

  // @GetMapping("/asistencia-usuario/{cif}")
  // public ResponseEntity<List<UsuarioEventoResponse>>
  // buscarAsistenciaUsuario2(@PathVariable Long cif) {
  // try {
  // return new
  // ResponseEntity<>(this.asistenciaUsuarioService.listarEventoPorCif2(cif),
  // HttpStatus.OK);
  // } catch (Exception e) {
  // System.out.println(e.getMessage());
  // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  // }
  // }

}
