package com.example.fhceegovfsra.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tiene")
public class EventoRequerimientos {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_evento_req", unique = true, nullable = false)
  private Long id_evento_req;

  @Column(name = "_01id_evento")
  private Long id_evento;

  @Column(name = "_02id_requerimiento")
  private Long id_requerimiento;

  public EventoRequerimientos() {
  }

  public EventoRequerimientos(Long id_evento_req, Long id_evento, Long id_requerimiento) {
    this.id_evento_req = id_evento_req;
    this.id_evento = id_evento;
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
