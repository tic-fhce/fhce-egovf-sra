package com.example.fhceegovfsra.object.ambiente;

public class AmbienteDTO {

  private Long idAmbiente;
  private String nombre;
  private int estado;

  public AmbienteDTO(Long id, String nombre, int estado) {
    this.idAmbiente = id;
    this.nombre = nombre;
    this.estado = estado;
  }

  public AmbienteDTO() {
  }

  public Long getIdAmbiente() {
    return idAmbiente;
  }

  public void setIdAmbiente(Long id) {
    this.idAmbiente = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }
}
