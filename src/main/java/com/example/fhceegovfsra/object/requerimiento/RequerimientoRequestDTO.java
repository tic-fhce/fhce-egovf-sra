package com.example.fhceegovfsra.object.requerimiento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequerimientoRequestDTO {
  private String cite;
  private String detalle;
}
