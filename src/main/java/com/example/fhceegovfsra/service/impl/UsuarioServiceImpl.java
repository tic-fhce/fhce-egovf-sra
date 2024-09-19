package com.example.fhceegovfsra.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.fhceegovfsra.dao.UsuarioDAO;
import com.example.fhceegovfsra.model.Usuario;

@Service
public class UsuarioServiceImpl {

  private final UsuarioDAO usuarioDAO;

  public UsuarioServiceImpl(UsuarioDAO usuarioDAO) {
    this.usuarioDAO = usuarioDAO;
  }

}
