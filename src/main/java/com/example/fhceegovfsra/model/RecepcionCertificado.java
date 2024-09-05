package com.example.fhceegovfsra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recibe")
public class RecepcionCertificado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_recepcion_certificado", unique = true, nullable = false)
  private Long idRecepcionCertificado;

  @Column(name = "_01cif")
  private Long cif;

  @ManyToOne
  @JoinColumn(name = "_02id_certificado")
  private Certificado certificado;

  public RecepcionCertificado(Long id_recepcion_certificado, Long cif, Certificado certificado) {
    this.idRecepcionCertificado = id_recepcion_certificado;
    this.cif = cif;
    this.certificado = certificado;
  }

  public RecepcionCertificado() {
  }

  public Long getIdRecepcionCertificado() {
    return idRecepcionCertificado;
  }

  public void setIdRecepcionCertificado(Long id_recepcion_certificado) {
    this.idRecepcionCertificado = id_recepcion_certificado;
  }

  public Long getCif() {
    return cif;
  }

  public void setCif(Long cif) {
    this.cif = cif;
  }

  public Certificado getCertificado() {
    return certificado;
  }

  public void setCertificado(Certificado certificado) {
    this.certificado = certificado;
  }

}
