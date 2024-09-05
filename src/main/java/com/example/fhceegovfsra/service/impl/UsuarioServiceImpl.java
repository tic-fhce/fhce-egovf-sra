package com.example.fhceegovfsra.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.fhceegovfsra.dao.UsuarioDAO;
import com.example.fhceegovfsra.model.Usuario;
import com.example.fhceegovfsra.object.usuario.UsuarioDTO;

@Service
public class UsuarioServiceImpl {

  private final UsuarioDAO usuarioDAO;

  public UsuarioServiceImpl(UsuarioDAO usuarioDAO) {
    this.usuarioDAO = usuarioDAO;
  }

  public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) {
    return convertirAObj(usuarioDAO.save(convertirAModel(usuarioDTO)));
  }

  public List<UsuarioDTO> listar() {
    return usuarioDAO.findAll().stream().map(this::convertirAObj).collect(Collectors.toList());
  }

  private UsuarioDTO convertirAObj(Usuario usuario) {
    return new UsuarioDTO(usuario.getIdUsuario(), usuario.getCif());
  }

  private Usuario convertirAModel(UsuarioDTO usuario) {
    return new Usuario(usuario.getId_usuario(), usuario.getCif());
  }
}
