package com.example.fhceegovfsra.object.asistencia_usuario;

import java.time.LocalDate;

public class AsistenciaUsuarioResponseDTO {
  private Long idAsistenciaUsuario;
  private Long cif;
  // private Long idEvento;
  private String nombreEvento;
  private LocalDate fechaReservaEvento;

  public AsistenciaUsuarioResponseDTO(Long idAsistenciaUsuario, Long cif, String nombreEvento,
      LocalDate fechaReservaEvento) {
    this.idAsistenciaUsuario = idAsistenciaUsuario;
    this.cif = cif;
    // this.idEvento = idEvento;
    this.nombreEvento = nombreEvento;
    this.fechaReservaEvento = fechaReservaEvento;
  }

  public AsistenciaUsuarioResponseDTO() {
  }

  public Long getIdAsistenciaUsuario() {
    return idAsistenciaUsuario;
  }

  public void setIdAsistenciaUsuario(Long idAsistenciaUsuario) {
    this.idAsistenciaUsuario = idAsistenciaUsuario;
  }

  public Long getCif() {
    return cif;
  }

  public void setCif(Long cif) {
    this.cif = cif;
  }

  // public Long getIdEvento() {
  // return idEvento;
  // }

  // public void setIdEvento(Long idEvento) {
  // this.idEvento = idEvento;
  // }

  public String getNombreEvento() {
    return nombreEvento;
  }

  public void setNombreEvento(String nombreEvento) {
    this.nombreEvento = nombreEvento;
  }

  public LocalDate getFechaReservaEvento() {
    return fechaReservaEvento;
  }

  public void setFechaReservaEvento(LocalDate fechaReservaEvento) {
    this.fechaReservaEvento = fechaReservaEvento;
  }

}
