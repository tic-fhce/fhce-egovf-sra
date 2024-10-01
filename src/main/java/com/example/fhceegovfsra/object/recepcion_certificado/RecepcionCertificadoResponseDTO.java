package com.example.fhceegovfsra.object.recepcion_certificado;

import com.example.fhceegovfsra.object.certificado.CertificadoResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecepcionCertificadoResponseDTO {
  private Long idRecepcionCertificado;
  private Long cif;
  private CertificadoResponseDTO certificado;

}
