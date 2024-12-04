package com.example.fhceegovfsra.object.asistencia_usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsistenciaUsuarioRequestDTO {
  private Long cif;
  private Long idEvento;

}
