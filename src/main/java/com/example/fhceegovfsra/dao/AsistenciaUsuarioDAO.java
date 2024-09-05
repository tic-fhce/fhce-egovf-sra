package com.example.fhceegovfsra.dao;

import com.example.fhceegovfsra.model.AsistenciaUsuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AsistenciaUsuarioDAO extends JpaRepository<AsistenciaUsuario, Long> {
  // @Query("SELECT new
  // com.example.fhceegovfsra.objects.responses.UsuarioEventoResponse(e.nombre_evento,
  // e.tipo.tipo, e.fecha_reserva, e.ambiente.nombre) FROM AsistenciaUsuario a
  // JOIN Evento e ON a.id_evento = e.id_evento WHERE a.cif = :cif")
  // List<UsuarioEventoResponse> findEventosByCif(@Param("cif") Long cif);

  @Query("SELECT a FROM AsistenciaUsuario a WHERE a.cif = :cif")
  public List<AsistenciaUsuario> findByCif(Long cif);
}
