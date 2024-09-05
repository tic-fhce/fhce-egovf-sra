package com.example.fhceegovfsra.object.tipo;

public class TipoDTO {

  private Long id_tipo;
  private String tipo;

  public TipoDTO(Long id_tipo, String tipo) {
    this.id_tipo = id_tipo;
    this.tipo = tipo;
  }

  public TipoDTO() {
  }

  public Long getId_tipo() {
    return id_tipo;
  }

  public void setId_tipo(Long id_tipo) {
    this.id_tipo = id_tipo;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
}
