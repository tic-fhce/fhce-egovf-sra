package com.example.fhceegovfsra.service.impl;

import com.example.fhceegovfsra.dao.AmbienteDAO;
import com.example.fhceegovfsra.dao.EventoDAO;
import com.example.fhceegovfsra.dao.RequerimientoDAO;
import com.example.fhceegovfsra.dao.TipoDAO;
import com.example.fhceegovfsra.model.Ambiente;
import com.example.fhceegovfsra.model.Evento;
import com.example.fhceegovfsra.model.Requerimiento;
import com.example.fhceegovfsra.model.Tipo;
import com.example.fhceegovfsra.object.evento.EventoRequestDTO;
import com.example.fhceegovfsra.object.evento.EventoResponseDTO;
import com.example.fhceegovfsra.service.EventoService;

import jakarta.transaction.Transactional;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EventoServiceImpl implements EventoService {

  private final EventoDAO eventoDAO;
  private final TipoDAO tipoDAO;
  private final AmbienteDAO ambienteDAO;
  private final RequerimientoDAO requerimientoDAO;
  private final ModelMapper modelMapper;

  public EventoServiceImpl(EventoDAO eventoDAO, TipoDAO tipoDAO, AmbienteDAO ambienteDAO,
      RequerimientoDAO requerimientoDAO, ModelMapper modelMapper) {
    this.eventoDAO = eventoDAO;
    this.tipoDAO = tipoDAO;
    this.ambienteDAO = ambienteDAO;
    this.requerimientoDAO = requerimientoDAO;
    this.modelMapper = modelMapper;
  }

  @Transactional
  public EventoResponseDTO agregarEvento(EventoRequestDTO eventoRequestDTO) {
    Tipo tipo = tipoDAO.findById(eventoRequestDTO.getIdTipo()).orElseThrow(
        () -> new RuntimeException("Tipo no encontrado"));
    Ambiente ambiente = ambienteDAO.findById(eventoRequestDTO.getIdAmbiente()).orElseThrow(
        () -> new RuntimeException("Ambiente no encontrado"));
    List<Requerimiento> requerimientos = requerimientoDAO.findAllById(eventoRequestDTO.getIdsRequerimientos());

    Evento evento = modelMapper.map(eventoRequestDTO, Evento.class);

    evento.setTipo(tipo);
    evento.setAmbiente(ambiente);
    evento.setRequerimientos(requerimientos);

    eventoDAO.save(evento);
    // EventoResponseDTO eventoResponseDTO = modelMapper.map(evento,
    // EventoResponseDTO.class);
    return modelMapper.map(evento, EventoResponseDTO.class);

  }

  @Transactional
  public List<EventoResponseDTO> listar() {
    List<Evento> eventos = eventoDAO.findAll();
    return eventos.stream().map(evento -> modelMapper.map(evento, EventoResponseDTO.class)).toList();
  }

}
