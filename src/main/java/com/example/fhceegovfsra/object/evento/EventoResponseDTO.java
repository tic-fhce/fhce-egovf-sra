package com.example.fhceegovfsra.object.evento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import com.example.fhceegovfsra.object.requerimiento.RequerimientoResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoResponseDTO {

  private Long idEvento;
  private String nombreEvento;
  private Long cif;
  private String cite;
  private String referencia;
  private LocalDate fechaEvento;
  private LocalTime horaInicio;
  private LocalTime horaFin;
  private int estado;
  private String hojaRuta;
  private LocalDate fechaReserva;
  private String tipo;
  private String nombreAmbiente;
  private List<RequerimientoResponseDTO> requerimientos;

}
