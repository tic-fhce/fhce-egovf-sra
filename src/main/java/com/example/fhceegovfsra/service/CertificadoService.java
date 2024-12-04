package com.example.fhceegovfsra.service;

import java.util.List;

import com.example.fhceegovfsra.object.certificado.CertificadoRequestDTO;
import com.example.fhceegovfsra.object.certificado.CertificadoResponseDTO;

public interface CertificadoService {
  CertificadoResponseDTO agregarCertificado(CertificadoRequestDTO certificadoDTO);

  List<CertificadoResponseDTO> listar();
}
