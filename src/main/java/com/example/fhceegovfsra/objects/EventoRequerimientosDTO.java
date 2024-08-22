package com.example.fhceegovfsra.objects;

public class EventoRequerimientosDTO {

  private Long id_evento_req;
  private Long id_evento;
  private Long id_requerimiento;

  public EventoRequerimientosDTO() {
  }

  public EventoRequerimientosDTO(Long id_evento_req, Long id_reserva, Long id_requerimiento) {
    this.id_evento_req = id_evento_req;
    this.id_evento = id_reserva;
    this.id_requerimiento = id_requerimiento;
  }

  public Long getId_evento_req() {
    return id_evento_req;
  }

  public void setId_evento_req(Long id_evento_req) {
    this.id_evento_req = id_evento_req;
  }

  public Long getId_evento() {
    return id_evento;
  }

  public void setId_evento(Long id_evento) {
    this.id_evento = id_evento;
  }

  public Long getId_requerimiento() {
    return id_requerimiento;
  }

  public void setId_requerimiento(Long id_requerimiento) {
    this.id_requerimiento = id_requerimiento;
  }

}
