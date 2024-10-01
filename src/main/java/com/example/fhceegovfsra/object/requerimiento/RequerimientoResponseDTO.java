package com.example.fhceegovfsra.object.requerimiento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequerimientoResponseDTO {
  private Long idRequerimiento;
  private String cite;
  private String detalle;
  private int estado;
}
