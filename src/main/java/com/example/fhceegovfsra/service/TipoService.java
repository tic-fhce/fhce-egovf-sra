package com.example.fhceegovfsra.service;

import com.example.fhceegovfsra.object.tipo.TipoRequestDTO;
import com.example.fhceegovfsra.object.tipo.TipoResponseDTO;

import java.util.List;

public interface TipoService {
  List<TipoResponseDTO> listar();

  TipoResponseDTO agregarTipo(TipoRequestDTO tipoRequestDTO);
}
