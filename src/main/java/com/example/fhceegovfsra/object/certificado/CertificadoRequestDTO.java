package com.example.fhceegovfsra.object.certificado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificadoRequestDTO {

  private Long idEvento;
  private int cargaHoraria;
  private String tipo;
  private String descripcion;
  private String modelo;
  private String titulo;
}
