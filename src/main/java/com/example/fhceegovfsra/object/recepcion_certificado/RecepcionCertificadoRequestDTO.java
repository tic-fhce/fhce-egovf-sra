package com.example.fhceegovfsra.object.recepcion_certificado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecepcionCertificadoRequestDTO {
  private Long cif;
  private Long idCertificado;
}
