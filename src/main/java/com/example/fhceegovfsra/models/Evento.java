package com.example.fhceegovfsra.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "eventos")
public class Evento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_evento", unique = true, nullable = false)
  private Long id_evento;

  @Column(name = "_01cif")
  private Long cif;

  @Column(name = "_02ambiente_id")
  private Long ambiente_id;

  @Column(name = "_03cite")
  private String cite;

  @Column(name = "_04referencia")
  private String referencia;

  @Column(name = "_05fecha_reserva")
  private LocalDate fecha_reserva;

  @Column(name = "_06hora_inicio")
  private LocalTime hora_inicio;

  @Column(name = "_07hora_fin")
  private LocalTime hora_fin;

  @Column(name = "_08estado")
  private int estado;

  @Column(name = "_09hoja_ruta")
  private String hoja_ruta;

  @Column(name = "_10fecha_actual")
  private LocalDate fecha_actual;

  public Evento(Long id_evento, Long cif, Long ambiente_id, String cite, String referencia, LocalDate fecha_reserva,
      LocalTime hora_inicio, LocalTime hora_fin, int estado, String hoja_ruta, LocalDate fecha_actual) {
    this.id_evento = id_evento;
    this.cif = cif;
    this.ambiente_id = ambiente_id;
    this.cite = cite;
    this.referencia = referencia;
    this.fecha_reserva = fecha_reserva;
    this.hora_inicio = hora_inicio;
    this.hora_fin = hora_fin;
    this.estado = estado;
    this.hoja_ruta = hoja_ruta;
    this.fecha_actual = fecha_actual;
  }

  public Evento() {
  }

  public Long getId_evento() {
    return id_evento;
  }

  public void setId_reserva(Long id_evento) {
    this.id_evento = id_evento;
  }

  public Long getCif() {
    return cif;
  }

  public void setCif(Long cif) {
    this.cif = cif;
  }

  public Long getAmbiente_id() {
    return ambiente_id;
  }

  public void setAmbiente_id(Long ambiente_id) {
    this.ambiente_id = ambiente_id;
  }

  public String getCite() {
    return cite;
  }

  public void setCite(String cite) {
    this.cite = cite;
  }

  public String getReferencia() {
    return referencia;
  }

  public void setReferencia(String referencia) {
    this.referencia = referencia;
  }

  public LocalDate getFecha_reserva() {
    return fecha_reserva;
  }

  public void setFecha_reserva(LocalDate fecha_reserva) {
    this.fecha_reserva = fecha_reserva;
  }

  public LocalTime getHora_inicio() {
    return hora_inicio;
  }

  public void setHora_inicio(LocalTime hora_inicio) {
    this.hora_inicio = hora_inicio;
  }

  public LocalTime getHora_fin() {
    return hora_fin;
  }

  public void setHora_fin(LocalTime hora_fin) {
    this.hora_fin = hora_fin;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

  public String getHoja_ruta() {
    return hoja_ruta;
  }

  public void setHoja_ruta(String hoja_ruta) {
    this.hoja_ruta = hoja_ruta;
  }

  public LocalDate getFecha_actual() {
    return fecha_actual;
  }

  public void setFecha_actual(LocalDate fecha_actual) {
    this.fecha_actual = fecha_actual;
  }

}
