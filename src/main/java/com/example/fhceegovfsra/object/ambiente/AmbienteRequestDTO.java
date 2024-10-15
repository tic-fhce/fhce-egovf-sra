package com.example.fhceegovfsra.object.ambiente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmbienteRequestDTO {
  private String nombre;
  private int capacidad;
}
