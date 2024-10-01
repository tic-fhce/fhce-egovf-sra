package com.example.fhceegovfsra.object.certificado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificadoResponseDTO {

  private Long idCertificado;
  private String nombreEvento;
  private int cargaHoraria;
  private String tipo;
  private String descripcion;
  private int estado;
  private String modelo;
  private String titulo;

}
