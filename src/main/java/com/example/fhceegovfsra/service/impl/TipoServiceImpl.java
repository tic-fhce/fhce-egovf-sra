package com.example.fhceegovfsra.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.fhceegovfsra.dao.TipoDAO;
import com.example.fhceegovfsra.model.Tipo;
import com.example.fhceegovfsra.object.tipo.TipoRequestDTO;
import com.example.fhceegovfsra.object.tipo.TipoResponseDTO;
import com.example.fhceegovfsra.service.TipoService;

import jakarta.transaction.Transactional;

@Service
public class TipoServiceImpl implements TipoService {
  private final TipoDAO tipoDAO;
  private final ModelMapper modelMapper;

  public TipoServiceImpl(TipoDAO tipoDAO, ModelMapper modelMapper) {
    this.tipoDAO = tipoDAO;
    this.modelMapper = modelMapper;
  }

  @Transactional
  public List<TipoResponseDTO> listar() {
    return tipoDAO.findAll().stream().map(tipo -> modelMapper.map(tipo, TipoResponseDTO.class)).toList();
  }

  @Transactional
  public TipoResponseDTO agregarTipo(TipoRequestDTO tipoRequestDTO) {
    return modelMapper.map(tipoDAO.save(modelMapper.map(tipoRequestDTO, Tipo.class)), TipoResponseDTO.class);
  }
}
