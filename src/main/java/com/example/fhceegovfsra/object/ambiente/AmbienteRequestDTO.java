package com.example.fhceegovfsra.object.ambiente;

public class AmbienteRequestDTO {
  private String nombre;
  private int capacidad;

  public AmbienteRequestDTO() {
  }

  public AmbienteRequestDTO(String nombre, int estado) {
    this.nombre = nombre;
    this.capacidad = estado;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(int estado) {
    this.capacidad = estado;
  }
}
