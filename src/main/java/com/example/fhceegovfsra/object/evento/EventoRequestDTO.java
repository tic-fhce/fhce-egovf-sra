package com.example.fhceegovfsra.object.evento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EventoRequestDTO {
  private String nombreEvento;
  private Long cif;
  private Long idAmbiente;
  private LocalDate fechaEvento;
  private LocalTime horaInicio;
  private LocalTime horaFin;
  private LocalDate fechaReserva;
  private Long idTipo;
  private List<Long> idsRequerimientos;

  private Long idEvento;

  public EventoRequestDTO() {
  }

  public EventoRequestDTO(String nombreEvento, Long cif, Long idAmbiente,
      LocalDate fechaEvento, LocalTime horaInicio, LocalTime horaFin, LocalDate fechaReserva,
      Long idTipo, List<Long> idsRequerimientos) {
    this.nombreEvento = nombreEvento;
    this.cif = cif;
    this.idAmbiente = idAmbiente;
    this.fechaEvento = fechaEvento;
    this.horaInicio = horaInicio;
    this.horaFin = horaFin;
    this.fechaReserva = fechaReserva;
    this.idTipo = idTipo;
    this.idsRequerimientos = idsRequerimientos;
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

  public Long getIdAmbiente() {
    return idAmbiente;
  }

  public void setIdAmbiente(Long idAmbiente) {
    this.idAmbiente = idAmbiente;
  }

  public LocalDate getFechaReserva() {
    return fechaReserva;
  }

  public void setFechaReserva(LocalDate fechaReserva) {
    this.fechaReserva = fechaReserva;
  }

  public Long getIdTipo() {
    return idTipo;
  }

  public void setIdTipo(Long idTipo) {
    this.idTipo = idTipo;
  }

  public List<Long> getIdsRequerimientos() {
    return idsRequerimientos;
  }

  public void setIdsRequerimientos(List<Long> idsRequerimientos) {
    this.idsRequerimientos = idsRequerimientos;
  }

  public LocalDate getFechaEvento() {
    return fechaEvento;
  }

  public void setFechaEvento(LocalDate fechaReserva) {
    this.fechaEvento = fechaReserva;
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

  public Long getIdEvento() {
    return idEvento;
  }

  public void setIdEvento(Long idEvento) {
    this.idEvento = idEvento;
  }

}
