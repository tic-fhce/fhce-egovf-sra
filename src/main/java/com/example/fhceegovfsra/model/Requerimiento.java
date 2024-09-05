package com.example.fhceegovfsra.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "requerimientos")
public class Requerimiento {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_requerimiento", unique = true, nullable = false)
  private Long idRequerimiento;

  @Column(name = "_01cite")
  private String cite;

  @Column(name = "_02detalle")
  private String detalle;

  @Column(name = "_03estado")
  private int estado = 0;

  @ManyToMany(mappedBy = "requerimientos", fetch = FetchType.LAZY)
  private List<Evento> eventos = new ArrayList<>();

  public Requerimiento(Long id_requerimiento, String cite, String detalle, List<Evento> eventos) {
    this.idRequerimiento = id_requerimiento;
    this.cite = cite;
    this.detalle = detalle;
    this.eventos = eventos;
  }

  public Requerimiento(Long id_requerimiento, String cite, String detalle, int estado) {
    this.idRequerimiento = id_requerimiento;
    this.cite = cite;
    this.detalle = detalle;
    this.estado = estado;
  }

  public Requerimiento() {
  }

  public Long getIdRequerimiento() {
    return idRequerimiento;
  }

  public void setIdRequerimiento(Long id_requerimiento) {
    this.idRequerimiento = id_requerimiento;
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

  public List<Evento> getEventos() {
    return eventos;
  }

  public void setEventos(List<Evento> eventos) {
    this.eventos = eventos;
  }

}
