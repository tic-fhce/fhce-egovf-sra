package com.example.fhceegovfsra.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.fhceegovfsra.dao.RequerimientoDAO;
import com.example.fhceegovfsra.model.Requerimiento;
import com.example.fhceegovfsra.object.requerimiento.RequerimientoRequestDTO;
import com.example.fhceegovfsra.object.requerimiento.RequerimientoResponseDTO;
import com.example.fhceegovfsra.service.RequerimientoService;

import jakarta.transaction.Transactional;

@Service
public class RequerimientoServiceImpl implements RequerimientoService {

  private final RequerimientoDAO requerimientoDAO;
  private final ModelMapper modelMapper;

  public RequerimientoServiceImpl(RequerimientoDAO requerimientoDAO, ModelMapper modelMapper) {
    this.requerimientoDAO = requerimientoDAO;
    this.modelMapper = modelMapper;
  }

  @Transactional
  public List<RequerimientoResponseDTO> listar() {
    List<RequerimientoResponseDTO> requerimientos = requerimientoDAO.findAll().stream()
        .map(requerimiento -> modelMapper.map(requerimiento, RequerimientoResponseDTO.class))
        .collect(Collectors.toList());
    return requerimientos;
  }

  @Transactional
  public RequerimientoResponseDTO agregarRequerimiento(RequerimientoRequestDTO requerimientoDTO) {
    requerimientoDAO.save(modelMapper.map(requerimientoDTO, Requerimiento.class));
    return modelMapper.map(requerimientoDTO, RequerimientoResponseDTO.class);
  }
}
