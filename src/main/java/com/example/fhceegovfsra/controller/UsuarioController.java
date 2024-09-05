package com.example.fhceegovfsra.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhceegovfsra.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/fhce-egovf-sra")
public class UsuarioController {
  private final UsuarioServiceImpl usuarioService;

  public UsuarioController(UsuarioServiceImpl usuarioService) {
    this.usuarioService = usuarioService;
  }

  // @GetMapping("/usuarios")
  // public ResponseEntity<List<UsuarioDTO>> listar(){
  // try {
  // return new ResponseEntity<>(this.usuarioService.listar(), HttpStatus.OK);
  // } catch (Exception e) {
  // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  // }
  // }

  // @PostMapping("/usuario")
  // public ResponseEntity<UsuarioDTO> agregarUsuario(@RequestBody UsuarioDTO
  // usuarioDTO) {
  // try {
  // return new ResponseEntity<>(this.usuarioService.agregarUsuario(usuarioDTO),
  // HttpStatus.CREATED);
  // } catch (Exception e) {
  // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  // }
  // }
}
