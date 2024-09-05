package com.example.fhceegovfsra.object.recepcion_certificado;

public class RecepcionCertificadoDTO {

  private Long id_recepcion_certificado;
  private Long cif;
  private Long id_certificado;

  public RecepcionCertificadoDTO(Long id_recepcion_certificado, Long cif, Long id_certificado) {
    this.id_recepcion_certificado = id_recepcion_certificado;
    this.cif = cif;
    this.id_certificado = id_certificado;
  }

  public RecepcionCertificadoDTO() {
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
