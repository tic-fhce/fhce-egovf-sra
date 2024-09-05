package com.example.fhceegovfsra.service;

import java.util.List;

import com.example.fhceegovfsra.object.ambiente.AmbienteRequestDTO;
import com.example.fhceegovfsra.object.ambiente.AmbienteResponseDTO;

public interface AmbienteService {
  List<AmbienteResponseDTO> listar();

  AmbienteResponseDTO agregarAmbiente(AmbienteRequestDTO ambienteDTO);
}
