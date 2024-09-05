package com.example.fhceegovfsra.service;

import java.util.List;

import com.example.fhceegovfsra.object.requerimiento.RequerimientoRequestDTO;
import com.example.fhceegovfsra.object.requerimiento.RequerimientoResponseDTO;

public interface RequerimientoService {
  public List<RequerimientoResponseDTO> listar();

  public RequerimientoResponseDTO agregarRequerimiento(RequerimientoRequestDTO requerimientoDTO);
}
