package com.example.fhceegovfsra.service;

import java.util.List;

import com.example.fhceegovfsra.object.evento.EventoRequestDTO;
import com.example.fhceegovfsra.object.evento.EventoResponseDTO;

public interface EventoService {
  public EventoResponseDTO agregarEvento(EventoRequestDTO eventoDTO);

  public List<EventoResponseDTO> listar();
}
