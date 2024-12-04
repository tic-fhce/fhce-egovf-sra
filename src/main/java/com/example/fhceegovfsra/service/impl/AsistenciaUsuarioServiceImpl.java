package com.example.fhceegovfsra.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.fhceegovfsra.dao.AsistenciaUsuarioDAO;
import com.example.fhceegovfsra.dao.EventoDAO;
import com.example.fhceegovfsra.model.AsistenciaUsuario;
import com.example.fhceegovfsra.model.Evento;
import com.example.fhceegovfsra.object.asistencia_usuario.AsistenciaUsuarioRequestDTO;
import com.example.fhceegovfsra.object.asistencia_usuario.AsistenciaUsuarioResponseDTO;
import com.example.fhceegovfsra.service.AsistenciaUsuarioService;

@Service
public class AsistenciaUsuarioServiceImpl implements AsistenciaUsuarioService {
  private final AsistenciaUsuarioDAO asistenciaUsuarioDAO;
  private final ModelMapper modelMapper;
  private final EventoDAO eventoDAO;

  public AsistenciaUsuarioServiceImpl(AsistenciaUsuarioDAO asistenciaUsuarioDAO, ModelMapper modelMapper,
      EventoDAO eventoDAO) {
    this.asistenciaUsuarioDAO = asistenciaUsuarioDAO;
    this.modelMapper = modelMapper;
    this.eventoDAO = eventoDAO;
  }

  public List<AsistenciaUsuarioResponseDTO> listar() {
    return asistenciaUsuarioDAO.findAll().stream()
        .map(asistenciaUsuario -> modelMapper.map(asistenciaUsuario, AsistenciaUsuarioResponseDTO.class)).toList();
  }

  public AsistenciaUsuarioResponseDTO agregarAsistenciaUsuario(AsistenciaUsuarioRequestDTO asistenciaUsuarioDTO) {
    Evento evento = eventoDAO.findById(asistenciaUsuarioDTO.getIdEvento()).orElseThrow(
        () -> new RuntimeException("No se encontró el evento"));
    AsistenciaUsuario asistenciaUsuario = modelMapper.map(asistenciaUsuarioDTO, AsistenciaUsuario.class);
    asistenciaUsuario.setEvento(evento);

    return modelMapper.map(asistenciaUsuarioDAO.save(asistenciaUsuario), AsistenciaUsuarioResponseDTO.class);

  }

  public List<AsistenciaUsuarioResponseDTO> listar(Long cif) {
    return asistenciaUsuarioDAO.findByCif(cif).stream()
        .map(asistenciaUsuario -> modelMapper.map(asistenciaUsuario, AsistenciaUsuarioResponseDTO.class)).toList();
  }

}
