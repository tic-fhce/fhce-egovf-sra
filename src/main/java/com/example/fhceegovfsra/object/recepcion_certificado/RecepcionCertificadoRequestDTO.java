package com.example.fhceegovfsra.object.recepcion_certificado;

public class RecepcionCertificadoRequestDTO {
  private Long cif;
  private Long idCertificado;

  public RecepcionCertificadoRequestDTO(Long cif, Long idCertificado) {
    this.cif = cif;
    this.idCertificado = idCertificado;
  }

  public RecepcionCertificadoRequestDTO() {
  }

  public Long getCif() {
    return cif;
  }

  public void setCif(Long cif) {
    this.cif = cif;
  }

  public Long getIdCertificado() {
    return idCertificado;
  }

  public void setIdCertificado(Long idCertificado) {
    this.idCertificado = idCertificado;
  }
}
