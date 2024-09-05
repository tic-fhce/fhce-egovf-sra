package com.example.fhceegovfsra.object.evento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.example.fhceegovfsra.object.ambiente.AmbienteDTO;
import com.example.fhceegovfsra.object.requerimiento.RequerimientoDTO;
import com.example.fhceegovfsra.object.tipo.TipoDTO;

public class EventoDTO {
  private Long id_evento;
  private String nombre;
  private Long cif;
  private AmbienteDTO ambiente;
  private String cite;
  private String referencia;
  private LocalDate fecha_reserva;
  private LocalTime hora_inicio;
  private LocalTime hora_fin;
  private int estado;
  private String hoja_ruta;
  private LocalDate fecha_actual;
  private TipoDTO tipo;
  private List<RequerimientoDTO> requerimientos;

  public EventoDTO(Long id_evento, String nombre, Long cif, AmbienteDTO ambiente, String cite, String referencia,
      LocalDate fecha_reserva,
      LocalTime hora_inicio, LocalTime hora_fin, int estado, String hoja_ruta, LocalDate fecha_actual, TipoDTO tipo,
      List<RequerimientoDTO> requerimientos) {
    this.nombre = nombre;
    this.id_evento = id_evento;
    this.cif = cif;
    this.ambiente = ambiente;
    this.cite = cite;
    this.referencia = referencia;
    this.fecha_reserva = fecha_reserva;
    this.hora_inicio = hora_inicio;
    this.hora_fin = hora_fin;
    this.estado = estado;
    this.hoja_ruta = hoja_ruta;
    this.fecha_actual = fecha_actual;
    this.tipo = tipo;
    this.requerimientos = requerimientos;
  }

  public EventoDTO(Long id_evento, String nombre, Long cif, AmbienteDTO ambiente, String cite, String referencia,
      LocalDate fecha_reserva,
      LocalTime hora_inicio, LocalTime hora_fin, int estado, String hoja_ruta, LocalDate fecha_actual, TipoDTO tipo) {
    this.id_evento = id_evento;
    this.nombre = nombre;
    this.cif = cif;
    this.ambiente = ambiente;
    this.cite = cite;
    this.referencia = referencia;
    this.fecha_reserva = fecha_reserva;
    this.hora_inicio = hora_inicio;
    this.hora_fin = hora_fin;
    this.estado = estado;
    this.hoja_ruta = hoja_ruta;
    this.fecha_actual = fecha_actual;
    this.tipo = tipo;
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

  public List<RequerimientoDTO> getRequerimientos() {
    return requerimientos;
  }

  public void setRequerimientos(List<RequerimientoDTO> requerimientos) {
    this.requerimientos = requerimientos;
  }

  public AmbienteDTO getAmbiente() {
    return ambiente;
  }

  public void setAmbiente(AmbienteDTO ambiente) {
    this.ambiente = ambiente;
  }

  public TipoDTO getTipo() {
    return tipo;
  }

  public void setTipo(TipoDTO tipo) {
    this.tipo = tipo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}
