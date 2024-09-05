package com.example.fhceegovfsra.object.requerimiento;

import java.util.List;

import com.example.fhceegovfsra.object.evento.EventoDTO;

public class RequerimientoDTO {

  private Long id;
  private String cite;
  private String detalle;
  private int estado;
  private List<EventoDTO> eventos;

  public RequerimientoDTO(Long id, String cite, String detalle, int estado, List<EventoDTO> eventos) {
    this.id = id;
    this.cite = cite;
    this.detalle = detalle;
    this.estado = estado;
    this.eventos = eventos;
  }

  public RequerimientoDTO(Long id, String cite, String detalle, int estado) {
    this.id = id;
    this.cite = cite;
    this.detalle = detalle;
    this.estado = estado;
  }

  public RequerimientoDTO() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public List<EventoDTO> getEventos() {
    return eventos;
  }

  public void setEventos(List<EventoDTO> eventos) {
    this.eventos = eventos;
  }

}
