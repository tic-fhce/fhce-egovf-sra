package com.example.fhceegovfsra.service.impl;

import java.util.Arrays;
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
    System.out.println("listar");
    List<AmbienteResponseDTO> ambientes = ambienteDAO.findAll().stream()
        .map(ambiente -> modelMapper.map(ambiente, AmbienteResponseDTO.class))
        .collect(Collectors.toList());
    System.out.println(Arrays.toString(ambientes.toArray()));
    return ambientes;
  }

  @Transactional
  public AmbienteResponseDTO agregarAmbiente(AmbienteRequestDTO ambienteDTO) {
    ambienteDAO.save(modelMapper.map(ambienteDTO, Ambiente.class));
    return modelMapper.map(ambienteDTO, AmbienteResponseDTO.class);
  }

}
