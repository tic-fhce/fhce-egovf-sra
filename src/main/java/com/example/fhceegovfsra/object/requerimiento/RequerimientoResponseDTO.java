package com.example.fhceegovfsra.object.requerimiento;

public class RequerimientoResponseDTO {
  private Long idRequerimiento;
  private String cite;
  private String detalle;
  private int estado;

  public RequerimientoResponseDTO(Long idRequerimiento, String cite, String detalle, int estado) {
    this.idRequerimiento = idRequerimiento;
    this.cite = cite;
    this.detalle = detalle;
    this.estado = estado;
  }

  public RequerimientoResponseDTO() {
  }

  public Long getIdRequerimiento() {
    return idRequerimiento;
  }

  public void setIdRequerimiento(Long idRequerimiento) {
    this.idRequerimiento = idRequerimiento;
  }

  public String getCite() {
    return cite;
  }

  public void setCite(String cite) {
    this.cite = cite;
  }

  public String getDetalle() {
    return detalle;
  }

  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }
}
