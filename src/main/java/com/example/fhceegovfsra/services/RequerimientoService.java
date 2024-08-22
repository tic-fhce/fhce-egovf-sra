package com.example.fhceegovfsra.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.fhceegovfsra.daos.RequerimientoDAO;
import com.example.fhceegovfsra.models.Requerimiento;
import com.example.fhceegovfsra.objects.RequerimientoDTO;

@Service
public class RequerimientoService {
  private final RequerimientoDAO requerimientoDAO;

  public RequerimientoService(RequerimientoDAO requerimientoDAO) {
    this.requerimientoDAO = requerimientoDAO;
  }

  public RequerimientoDTO agregarRequerimiento(RequerimientoDTO requerimientoDTO) {
    return convertirAObj(requerimientoDAO.save(convertirAModel(requerimientoDTO)));
  }

  public List<RequerimientoDTO> listar() {
    return requerimientoDAO.findAll().stream().map(this::convertirAObj).collect(Collectors.toList());
  }

  private RequerimientoDTO convertirAObj(Requerimiento requerimiento) {
    return new RequerimientoDTO(requerimiento.getId_requerimiento(), requerimiento.getCite(),
        requerimiento.getDetalle(), requerimiento.getEstado());
  }

  private Requerimiento convertirAModel(RequerimientoDTO requerimiento) { // Modelmapper
    return new Requerimiento(requerimiento.getId(), requerimiento.getCite(), requerimiento.getDetalle(),
        requerimiento.getEstado());
  }

}
