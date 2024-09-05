package com.example.fhceegovfsra.object.evento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.example.fhceegovfsra.object.requerimiento.RequerimientoResponseDTO;

public class EventoResponseDTO {

  private Long idEvento;
  private String nombreEvento;
  private Long cif;
  private String cite;
  private String referencia;
  private LocalDate fechaEvento;
  private LocalTime horaInicio;
  private LocalTime horaFin;
  private int estado;
  private String hojaRuta;
  private LocalDate fechaReserva;
  private String tipo;
  private String nombreAmbiente;
  private List<RequerimientoResponseDTO> requerimientos;

  public EventoResponseDTO() {
  }

  public EventoResponseDTO(Long idEvento, String nombreEvento, Long cif, String cite,
      String referencia,
      LocalDate fechaEvento, LocalTime horaInicio, LocalTime horaFin, int estado, String hojaRuta,
      LocalDate fechaReserva,
      String tipo, String nombreAmbiente, List<RequerimientoResponseDTO> requerimientos) {
    this.idEvento = idEvento;
    this.nombreEvento = nombreEvento;
    this.cif = cif;
    this.cite = cite;
    this.referencia = referencia;
    this.fechaEvento = fechaEvento;
    this.horaInicio = horaInicio;
    this.horaFin = horaFin;
    this.estado = estado;
    this.hojaRuta = hojaRuta;
    this.fechaReserva = fechaReserva;
    this.tipo = tipo;
    this.nombreAmbiente = nombreAmbiente;
    this.requerimientos = requerimientos;
  }

  public Long getIdEvento() {
    return idEvento;
  }

  public void setIdEvento(Long idEvento) {
    this.idEvento = idEvento;
  }

  public String getNombreEvento() {
    return nombreEvento;
  }

  public void setNombreEvento(String nombreEvento) {
    this.nombreEvento = nombreEvento;
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

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

  public String getHojaRuta() {
    return hojaRuta;
  }

  public void setHojaRuta(String hojaRuta) {
    this.hojaRuta = hojaRuta;
  }

  public LocalDate getFechaReserva() {
    return fechaReserva;
  }

  public void setFechaReserva(LocalDate fechaReserva) {
    this.fechaReserva = fechaReserva;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String nombreTipo) {
    this.tipo = nombreTipo;
  }

  public String getNombreAmbiente() {
    return nombreAmbiente;
  }

  public void setNombreAmbiente(String nombreAmbiente) {
    this.nombreAmbiente = nombreAmbiente;
  }

  public LocalDate getFechaEvento() {
    return fechaEvento;
  }

  public void setFechaEvento(LocalDate fechaEvento) {
    this.fechaEvento = fechaEvento;
  }

  public LocalTime getHoraInicio() {
    return horaInicio;
  }

  public void setHoraInicio(LocalTime horaInicio) {
    this.horaInicio = horaInicio;
  }

  public LocalTime getHoraFin() {
    return horaFin;
  }

  public void setHoraFin(LocalTime horaFin) {
    this.horaFin = horaFin;
  }

  public List<RequerimientoResponseDTO> getRequerimientos() {
    return requerimientos;
  }

  public void setRequerimientos(List<RequerimientoResponseDTO> requerimientos) {
    this.requerimientos = requerimientos;
  }
}
