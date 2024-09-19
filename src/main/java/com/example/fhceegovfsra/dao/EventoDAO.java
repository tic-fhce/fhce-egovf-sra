package com.example.fhceegovfsra.dao;

import com.example.fhceegovfsra.model.Evento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventoDAO extends JpaRepository<Evento, Long> {
  @Query("SELECT e FROM Evento e WHERE e.estado = 0")
  public List<Evento> findAllEventosPendientes();

  @Query("SELECT e FROM Evento e WHERE e.estado = 1")
  public List<Evento> findAllEventosConfirmados();

  @Query("SELECT e FROM Evento e WHERE e.estado = 2")
  public List<Evento> findAllEventosTerminados();
}
