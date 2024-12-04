package com.example.fhceegovfsra.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.fhceegovfsra.dao.AmbienteDAO;
import com.example.fhceegovfsra.model.Ambiente;
import com.example.fhceegovfsra.object.ambiente.AmbienteRequestDTO;
import com.example.fhceegovfsra.object.ambiente.AmbienteResponseDTO;
import com.example.fhceegovfsra.service.AmbienteService;

import jakarta.transaction.Transactional;

@Service
public class AmbienteServiceImpl implements AmbienteService {

  private final AmbienteDAO ambienteDAO;
  private final ModelMapper modelMapper;

  public AmbienteServiceImpl(AmbienteDAO ambienteDAO, ModelMapper modelMapper) {
    this.ambienteDAO = ambienteDAO;
    this.modelMapper = modelMapper;
  }

  @Transactional
  public List<AmbienteResponseDTO> listar() {
    List<AmbienteResponseDTO> ambientes = ambienteDAO.findAll().stream()
        .map(ambiente -> modelMapper.map(ambiente, AmbienteResponseDTO.class))
        .collect(Collectors.toList());
    return ambientes;
  }

  @Transactional
  public AmbienteResponseDTO agregarAmbiente(AmbienteRequestDTO ambienteDTO) {
    Ambiente ambiente = modelMapper.map(ambienteDTO, Ambiente.class);
    ambienteDAO.save(ambiente);
    return modelMapper.map(ambiente, AmbienteResponseDTO.class);
  }

}
