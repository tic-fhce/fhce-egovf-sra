package com.example.fhceegovfsra.object.asistencia_usuario;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsistenciaUsuarioResponseDTO {
  private Long idAsistenciaUsuario;
  private Long cif;
  private String nombreEvento;
  private LocalDate fechaReservaEvento;
}
