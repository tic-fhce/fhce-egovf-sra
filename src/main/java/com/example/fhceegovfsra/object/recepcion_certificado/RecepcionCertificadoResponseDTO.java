package com.example.fhceegovfsra.object.recepcion_certificado;

import com.example.fhceegovfsra.object.certificado.CertificadoResponseDTO;

public class RecepcionCertificadoResponseDTO {
  private Long idRecepcionCertificado;
  private Long cif;
  private CertificadoResponseDTO certificado;

  public RecepcionCertificadoResponseDTO(Long idRecepcionCertificado, Long cif, CertificadoResponseDTO Evento) {
    this.idRecepcionCertificado = idRecepcionCertificado;
    this.cif = cif;
    this.certificado = Evento;
  }

  public RecepcionCertificadoResponseDTO() {
  }

  public Long getIdRecepcionCertificado() {
    return idRecepcionCertificado;
  }

  public void setIdRecepcionCertificado(Long idRecepcionCertificado) {
    this.idRecepcionCertificado = idRecepcionCertificado;
  }

  public Long getCif() {
    return cif;
  }

  public void setCif(Long cif) {
    this.cif = cif;
  }

  public CertificadoResponseDTO getCertificado() {
    return certificado;
  }

  public void setCertificado(CertificadoResponseDTO evento) {
    this.certificado = evento;
  }

}
