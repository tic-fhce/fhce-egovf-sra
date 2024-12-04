package com.example.fhceegovfsra.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.fhceegovfsra.dao.CertificadoDAO;
import com.example.fhceegovfsra.dao.EventoDAO;
import com.example.fhceegovfsra.model.Certificado;
import com.example.fhceegovfsra.model.Evento;
import com.example.fhceegovfsra.object.certificado.CertificadoRequestDTO;
import com.example.fhceegovfsra.object.certificado.CertificadoResponseDTO;
import com.example.fhceegovfsra.service.CertificadoService;

import jakarta.transaction.Transactional;

@Service
public class CertificadoServiceImpl implements CertificadoService {
  private final CertificadoDAO certificadoDAO;
  private final ModelMapper modelMapper;
  private final EventoDAO eventoDAO;

  public CertificadoServiceImpl(CertificadoDAO certificadoDAO, ModelMapper modelMapper, EventoDAO eventoDAO) {
    this.certificadoDAO = certificadoDAO;
    this.modelMapper = modelMapper;
    this.eventoDAO = eventoDAO;
  }

  @Transactional
  public CertificadoResponseDTO agregarCertificado(CertificadoRequestDTO certificadoDTO) {
    Evento evento = eventoDAO.findById(certificadoDTO.getIdEvento())
        .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

    Certificado certificado = modelMapper.map(certificadoDTO, Certificado.class);
    certificado.setEvento(evento);
    certificadoDAO.save(certificado);

    return modelMapper.map(certificado, CertificadoResponseDTO.class);

  }

  @Transactional
  public List<CertificadoResponseDTO> listar() {
    List<Certificado> certificados = certificadoDAO.findAll();
    return certificados.stream().map(certificado -> modelMapper.map(certificado, CertificadoResponseDTO.class))
        .toList();

  }

}
