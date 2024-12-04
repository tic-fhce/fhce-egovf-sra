package com.example.fhceegovfsra.service;

import java.util.List;

import com.example.fhceegovfsra.object.asistencia_usuario.AsistenciaUsuarioRequestDTO;
import com.example.fhceegovfsra.object.asistencia_usuario.AsistenciaUsuarioResponseDTO;

public interface AsistenciaUsuarioService {
  public List<AsistenciaUsuarioResponseDTO> listar();

  public AsistenciaUsuarioResponseDTO agregarAsistenciaUsuario(AsistenciaUsuarioRequestDTO asistenciaUsuarioDTO);

  public List<AsistenciaUsuarioResponseDTO> listar(Long cif);
}
