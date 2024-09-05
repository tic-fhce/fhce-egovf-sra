package com.example.fhceegovfsra.object.requerimiento;

public class RequerimientoRequestDTO {
  private String cite;
  private String detalle;

  public RequerimientoRequestDTO(String cite, String detalle) {
    this.cite = cite;
    this.detalle = detalle;
  }

  public RequerimientoRequestDTO() {
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

}
