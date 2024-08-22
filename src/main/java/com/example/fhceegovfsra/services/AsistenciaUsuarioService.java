package com.example.fhceegovfsra.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.fhceegovfsra.daos.AsistenciaUsuarioDAO;
import com.example.fhceegovfsra.models.AsistenciaUsuario;
import com.example.fhceegovfsra.objects.AsistenciaUsuarioDTO;

@Service
public class AsistenciaUsuarioService {
  private final AsistenciaUsuarioDAO asistenciaUsuarioDAO;

  public AsistenciaUsuarioService(AsistenciaUsuarioDAO asistenciaUsuarioDAO) {
    this.asistenciaUsuarioDAO = asistenciaUsuarioDAO;
  }

  public AsistenciaUsuarioDTO agregarAsistenciaUsuario(AsistenciaUsuarioDTO asistenciaUsuarioDTO) {
    return convertirAObj(asistenciaUsuarioDAO.save(convertirAModel(asistenciaUsuarioDTO)));
  }

  public List<AsistenciaUsuarioDTO> listar() {
    return asistenciaUsuarioDAO.findAll().stream().map(this::convertirAObj).collect(Collectors.toList());
  }

  private AsistenciaUsuarioDTO convertirAObj(AsistenciaUsuario asistenciaUsuario) {
    return new AsistenciaUsuarioDTO(asistenciaUsuario.getId_asistencia_usuario(), asistenciaUsuario.getCif(),
        asistenciaUsuario.getId_evento());
  }

  private AsistenciaUsuario convertirAModel(AsistenciaUsuarioDTO asistenciaUsuario) { // Modelmapper
    return new AsistenciaUsuario(asistenciaUsuario.getId_asistencia_usuario(), asistenciaUsuario.getCif(),
        asistenciaUsuario.getId_evento());
  }
}
