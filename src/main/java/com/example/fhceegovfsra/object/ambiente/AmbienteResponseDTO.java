package com.example.fhceegovfsra.object.ambiente;

public class AmbienteResponseDTO {
  private Long idAmbiente;
  private String nombre;
  private int estado;
  private int capacidad;

  public AmbienteResponseDTO() {
  }

  public AmbienteResponseDTO(Long idAmbiente, String nombre, int estado, int capacidad) {
    this.idAmbiente = idAmbiente;
    this.nombre = nombre;
    this.estado = estado;
    this.capacidad = capacidad;
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

  public Long getIdAmbiente() {
    return idAmbiente;
  }

  public void setIdAmbiente(Long idAmbiente) {
    this.idAmbiente = idAmbiente;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(int capacidad) {
    this.capacidad = capacidad;
  }
}
