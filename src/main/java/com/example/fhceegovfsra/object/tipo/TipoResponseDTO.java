package com.example.fhceegovfsra.object.tipo;

public class TipoResponseDTO {
  private Long idTipo;
  private String tipo;

  public TipoResponseDTO(String tipo) {
    this.tipo = tipo;
  }

  public TipoResponseDTO() {
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String nombre) {
    this.tipo = nombre;
  }

  public Long getIdTipo() {
    return idTipo;
  }

  public void setIdTipo(Long idTipo) {
    this.idTipo = idTipo;
  }

}
