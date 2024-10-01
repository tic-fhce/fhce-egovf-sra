package com.example.fhceegovfsra.object.evento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoRequestDTO {
  private String nombreEvento;
  private Long cif;
  private Long idAmbiente;
  private LocalDate fechaEvento;
  private LocalTime horaInicio;
  private LocalTime horaFin;
  private LocalDate fechaReserva;
  private Long idTipo;
  private List<Long> idsRequerimientos;
  private Long idEvento;

}
