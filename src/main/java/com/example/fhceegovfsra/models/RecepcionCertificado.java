package com.example.fhceegovfsra.models;

import jakarta.persistence.*;

@Entity
@Table(name = "recibe")
public class RecepcionCertificado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_recepcion_certificado", unique = true, nullable = false)
  private Long id_recepcion_certificado;

  @Column(name = "_01cif")
  private Long cif;

  @Column(name = "_02id_certificado")
  private Long id_certificado;

  public RecepcionCertificado(Long id_recepcion_certificado, Long cif, Long id_certificado) {
    this.id_recepcion_certificado = id_recepcion_certificado;
    this.cif = cif;
    this.id_certificado = id_certificado;
  }

  public RecepcionCertificado() {
  }

  public Long getId_recepcion_certificado() {
    return id_recepcion_certificado;
  }

  public void setId_recepcion_certificado(Long id_recepcion_certificado) {
    this.id_recepcion_certificado = id_recepcion_certificado;
  }

  public Long getCif() {
    return cif;
  }

  public void setCif(Long cif) {
    this.cif = cif;
  }

  public Long getId_certificado() {
    return id_certificado;
  }

  public void setId_certificado(Long id_certificado) {
    this.id_certificado = id_certificado;
  }
}
