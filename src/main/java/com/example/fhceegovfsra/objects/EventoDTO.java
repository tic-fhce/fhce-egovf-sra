package com.example.fhceegovfsra.objects;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventoDTO {
  private Long id_evento;
  private Long cif;
  private Long ambiente_id;
  private String cite;
  private String referencia;
  private LocalDate fecha_reserva;
  private LocalTime hora_inicio;
  private LocalTime hora_fin;
  private int estado;
  private String hoja_ruta;
  private LocalDate fecha_actual;

  public EventoDTO(Long id_evento, Long cif, Long ambiente_id, String cite, String referencia, LocalDate fecha_reserva,
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

  public EventoDTO() {
  }

  public Long getId_evento() {
    return id_evento;
  }

  public void setId_evento(Long id_evento) {
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
