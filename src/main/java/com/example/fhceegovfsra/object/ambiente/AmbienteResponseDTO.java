package com.example.fhceegovfsra.object.ambiente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmbienteResponseDTO {
  private Long idAmbiente;
  private String nombre;
  private int estado;
  private int capacidad;

}
