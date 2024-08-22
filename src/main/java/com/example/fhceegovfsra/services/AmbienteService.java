package com.example.fhceegovfsra.services;

import com.example.fhceegovfsra.daos.AmbienteDAO;
import com.example.fhceegovfsra.models.Ambiente;
import com.example.fhceegovfsra.objects.AmbienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AmbienteService {
  private final AmbienteDAO ambienteDAO;

  public AmbienteService(AmbienteDAO ambienteDAO) {
    this.ambienteDAO = ambienteDAO;
  }

  public AmbienteDTO agregarAmbiente(AmbienteDTO ambienteDTO) {
    return convertirAObj(ambienteDAO.save(convertirAModel(ambienteDTO)));
  }

  public List<AmbienteDTO> listar() {
    return ambienteDAO.findAll().stream().map(this::convertirAObj).collect(Collectors.toList());
  }

  private AmbienteDTO convertirAObj(Ambiente ambiente) {
    return new AmbienteDTO(ambiente.getId_ambiente(), ambiente.getNombre(), ambiente.getEstado());
  }

  private Ambiente convertirAModel(AmbienteDTO ambiente) { // Modelmapper
    return new Ambiente(ambiente.getId_ambiente(), ambiente.getNombre(), ambiente.getEstado());
  }

}
