package com.example.fhceegovfsra.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.fhceegovfsra.daos.RecepcionCertificadoDAO;
import com.example.fhceegovfsra.models.RecepcionCertificado;
import com.example.fhceegovfsra.objects.RecepcionCertificadoDTO;

@Service
public class RecepcionCertificadoService {
  private final RecepcionCertificadoDAO recepcionCertificadoDAO;

  public RecepcionCertificadoService(RecepcionCertificadoDAO recepcionCertificadoDAO) {
    this.recepcionCertificadoDAO = recepcionCertificadoDAO;
  }

  public RecepcionCertificadoDTO agregarRecepcionCertificado(RecepcionCertificadoDTO recepcionCertificadoDTO) {
    return convertirAObj(recepcionCertificadoDAO.save(convertirAModel(recepcionCertificadoDTO)));
  }

  public List<RecepcionCertificadoDTO> listar() {
    return recepcionCertificadoDAO.findAll().stream().map(this::convertirAObj).collect(Collectors.toList());
  }

  private RecepcionCertificado convertirAModel(RecepcionCertificadoDTO recepcionCertificadoDTO) {
    return new RecepcionCertificado(recepcionCertificadoDTO.getId_recepcion_certificado(),
        recepcionCertificadoDTO.getCif(), recepcionCertificadoDTO.getId_certificado());

  }

  private RecepcionCertificadoDTO convertirAObj(RecepcionCertificado recepcionCertificado) {
    return new RecepcionCertificadoDTO(recepcionCertificado.getId_recepcion_certificado(),
        recepcionCertificado.getCif(), recepcionCertificado.getId_certificado());

  }

}
