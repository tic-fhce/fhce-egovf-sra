package com.example.fhceegovfsra.services;

import com.example.fhceegovfsra.daos.EventoDAO;
import com.example.fhceegovfsra.models.Evento;
import com.example.fhceegovfsra.objects.EventoDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class EventoService {
  private final EventoDAO eventoDAO;

  public EventoService(EventoDAO eventoDAO) {
    this.eventoDAO = eventoDAO;
  }

  public EventoDTO agregarEvento(EventoDTO eventoDTO) {
    return convertirAObj(eventoDAO.save(convertirAModel(eventoDTO)));
  }

  public List<EventoDTO> listar() {
    return eventoDAO.findAll().stream().map(this::convertirAObj).collect(Collectors.toList());
  }

  private EventoDTO convertirAObj(Evento evento) {
    return new EventoDTO(evento.getId_evento(), evento.getCif(), evento.getAmbiente_id(), evento.getCite(),
        evento.getReferencia(), evento.getFecha_reserva(), evento.getHora_inicio(), evento.getHora_fin(),
        evento.getEstado(), evento.getHoja_ruta(), evento.getFecha_actual());
  }

  private Evento convertirAModel(EventoDTO evento) {
    return new Evento(evento.getId_evento(), evento.getCif(), evento.getAmbiente_id(), evento.getCite(),
        evento.getReferencia(), evento.getFecha_reserva(), evento.getHora_inicio(), evento.getHora_fin(),
        evento.getEstado(), evento.getHoja_ruta(), evento.getFecha_actual());
  }
}
