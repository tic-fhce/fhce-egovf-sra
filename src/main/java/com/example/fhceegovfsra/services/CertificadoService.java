package com.example.fhceegovfsra.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.fhceegovfsra.daos.CertificadoDAO;
import com.example.fhceegovfsra.models.Certificado;
import com.example.fhceegovfsra.objects.CertificadoDTO;

@Service
public class CertificadoService {
  private final CertificadoDAO certificadoDAO;

  public CertificadoService(CertificadoDAO certificadoDAO) {
    this.certificadoDAO = certificadoDAO;
  }

  public CertificadoDTO agregarCertificado(CertificadoDTO certificadoDTO) {
    return convertirAObj(certificadoDAO.save(convertirAModel(certificadoDTO)));
  }

  public List<CertificadoDTO> listar() {
    return certificadoDAO.findAll().stream().map(this::convertirAObj).collect(Collectors.toList());
  }

  private CertificadoDTO convertirAObj(Certificado certificado) {
    return new CertificadoDTO(certificado.getId_certificado(), certificado.getId_evento(),
        certificado.getCarga_horaria(), certificado.getTipo(), certificado.getDescripcion(), certificado.getEstado(),
        certificado.getModelo());
  }

  private Certificado convertirAModel(CertificadoDTO certificadoDTO) {
    return new Certificado(certificadoDTO.getId_certificado(), certificadoDTO.getId_evento(),
        certificadoDTO.getCarga_horaria(), certificadoDTO.getTipo(), certificadoDTO.getDescripcion(),
        certificadoDTO.getEstado(), certificadoDTO.getModelo());
  }
}
