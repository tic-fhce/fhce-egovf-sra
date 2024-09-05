package com.example.fhceegovfsra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ambientes")
public class Ambiente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_ambiente", unique = true, nullable = false)
  private Long idAmbiente;

  @Column(name = "_01nombre")
  private String nombre;

  @Column(name = "_02estado")
  private int estado = 0;

  @Column(name = "_03capacidad")
  private int capacidad;

  public Ambiente(Long id_ambiente, int estado, String nombre, int capacidad) {
    this.idAmbiente = id_ambiente;
    this.nombre = nombre;
    this.estado = estado;
    this.capacidad = capacidad;
  }

  public Ambiente(Long id_ambiente, String nombre, int capacidad) {
    this.idAmbiente = id_ambiente;
    this.nombre = nombre;
    this.capacidad = capacidad;
  }

  public Ambiente() {
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

  public void setIdAmbiente(Long id_ambiente) {
    this.idAmbiente = id_ambiente;
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

  public void setCapacidad(int capacidad) {
    this.capacidad = capacidad;
  }
}
