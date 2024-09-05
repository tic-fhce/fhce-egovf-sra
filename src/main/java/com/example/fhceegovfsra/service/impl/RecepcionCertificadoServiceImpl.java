package com.example.fhceegovfsra.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.fhceegovfsra.dao.CertificadoDAO;
import com.example.fhceegovfsra.dao.RecepcionCertificadoDAO;
import com.example.fhceegovfsra.model.Certificado;
import com.example.fhceegovfsra.model.RecepcionCertificado;
import com.example.fhceegovfsra.object.recepcion_certificado.RecepcionCertificadoRequestDTO;
import com.example.fhceegovfsra.object.recepcion_certificado.RecepcionCertificadoResponseDTO;
import com.example.fhceegovfsra.service.RecepcionCertificadoService;

import jakarta.transaction.Transactional;

@Service
public class RecepcionCertificadoServiceImpl implements RecepcionCertificadoService {
  private final CertificadoDAO certificadoDAO;
  private final RecepcionCertificadoDAO recepcionCertificadoDAO;
  private final ModelMapper modelMapper;

  public RecepcionCertificadoServiceImpl(RecepcionCertificadoDAO recepcionCertificadoDAO, ModelMapper modelMapper,
      CertificadoDAO certificadoDAO) {
    this.modelMapper = modelMapper;
    this.recepcionCertificadoDAO = recepcionCertificadoDAO;
    this.certificadoDAO = certificadoDAO;
  }

  @Transactional
  public RecepcionCertificadoResponseDTO agregarRecepcionCertificado(
      RecepcionCertificadoRequestDTO recepcionCertificadoDTO) {
    Certificado certificado = certificadoDAO.findById(recepcionCertificadoDTO.getIdCertificado()).orElseThrow(
        () -> new RuntimeException("Certificado no encontrado"));

    RecepcionCertificado recepcionCertificado = modelMapper.map(recepcionCertificadoDTO, RecepcionCertificado.class);
    recepcionCertificado.setCertificado(certificado);

    recepcionCertificadoDAO.save(recepcionCertificado);

    RecepcionCertificadoResponseDTO recepcionCertificadoResponseDTO = modelMapper.map(recepcionCertificado,
        RecepcionCertificadoResponseDTO.class);

    return recepcionCertificadoResponseDTO;
  }

  @Transactional
  public List<RecepcionCertificadoResponseDTO> listar() {
    List<RecepcionCertificado> recepcionCertificados = recepcionCertificadoDAO.findAll();
    return recepcionCertificados.stream().map(recepcionCertificado -> modelMapper.map(recepcionCertificado,
        RecepcionCertificadoResponseDTO.class)).toList();
  }

  @Transactional
  public List<RecepcionCertificadoResponseDTO> listar(Long cif) {
    List<RecepcionCertificado> recepcionCertificados = recepcionCertificadoDAO.findByCif(cif);
    return recepcionCertificados.stream().map(recepcionCertificado -> modelMapper.map(recepcionCertificado,
        RecepcionCertificadoResponseDTO.class)).toList();
  }
}
