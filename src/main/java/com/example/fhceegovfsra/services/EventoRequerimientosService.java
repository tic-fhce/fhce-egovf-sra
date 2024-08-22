package com.example.fhceegovfsra.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.fhceegovfsra.daos.EventoRequerimientosDAO;
import com.example.fhceegovfsra.models.EventoRequerimientos;
import com.example.fhceegovfsra.objects.EventoRequerimientosDTO;

@Service
public class EventoRequerimientosService {

  private final EventoRequerimientosDAO eventoRequerimientosDAO;

  public EventoRequerimientosService(EventoRequerimientosDAO eventoRequerimientosDAO) {
    this.eventoRequerimientosDAO = eventoRequerimientosDAO;
  }

  public EventoRequerimientosDTO agregarEventoRequerimiento(EventoRequerimientosDTO eventoRequerimientosDTO) {
    return convertirAObj(eventoRequerimientosDAO.save(convertirAModel(eventoRequerimientosDTO)));
  }

  public List<EventoRequerimientosDTO> listar() {
    return eventoRequerimientosDAO.findAll().stream().map(this::convertirAObj)
        .collect(Collectors.toList());
  }

  private EventoRequerimientosDTO convertirAObj(EventoRequerimientos eventoRequerimientos) {
    return new EventoRequerimientosDTO(eventoRequerimientos.getId_evento_req(), eventoRequerimientos.getId_evento(),
        eventoRequerimientos.getId_requerimiento());
  }

  private EventoRequerimientos convertirAModel(EventoRequerimientosDTO eventoRequerimientosDTO) {
    return new EventoRequerimientos(eventoRequerimientosDTO.getId_evento_req(), eventoRequerimientosDTO.getId_evento(),
        eventoRequerimientosDTO.getId_requerimiento());
  }

}
