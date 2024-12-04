package com.example.fhceegovfsra.service;

import java.util.List;

import com.example.fhceegovfsra.object.recepcion_certificado.RecepcionCertificadoRequestDTO;
import com.example.fhceegovfsra.object.recepcion_certificado.RecepcionCertificadoResponseDTO;

public interface RecepcionCertificadoService {
  public RecepcionCertificadoResponseDTO agregarRecepcionCertificado(
      RecepcionCertificadoRequestDTO recepcionCertificadoDTO);

  public List<RecepcionCertificadoResponseDTO> listar();

  public List<RecepcionCertificadoResponseDTO> listar(Long cif);
}
