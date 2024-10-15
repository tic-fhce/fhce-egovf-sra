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

}
