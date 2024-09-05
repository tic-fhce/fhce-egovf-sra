package com.example.fhceegovfsra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asiste")
public class AsistenciaUsuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_asistencia_usuario", unique = true, nullable = false)
  private Long idAsistenciaUsuario;

  @Column(name = "_01cif")
  private Long cif;

  @ManyToOne
  @JoinColumn(name = "_02id_evento")
  private Evento evento;

  public AsistenciaUsuario(Long id_asistencia_usuario, Long cif, Evento evento) {
    this.idAsistenciaUsuario = id_asistencia_usuario;
    this.cif = cif;
    this.evento = evento;
  }

  public AsistenciaUsuario() {
  }

  public Long getIdAsistenciaUsuario() {
    return idAsistenciaUsuario;
  }

  public void setIdAsistenciaUsuario(Long id_asistencia_usuario) {
    this.idAsistenciaUsuario = id_asistencia_usuario;
  }

  public Long getCif() {
    return cif;
  }

  public void setCif(Long cif) {
    this.cif = cif;
  }

  public Evento getEvento() {
    return evento;
  }

  public void setEvento(Evento evento) {
    this.evento = evento;
  }

}
