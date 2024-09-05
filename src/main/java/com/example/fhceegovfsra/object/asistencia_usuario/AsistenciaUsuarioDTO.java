package com.example.fhceegovfsra.object.asistencia_usuario;

public class AsistenciaUsuarioDTO {
  private Long id_asistencia_usuario;
  private Long cif;
  private Long id_evento;

  public AsistenciaUsuarioDTO(Long id_asistencia_usuario, Long cif, Long id_evento) {
    this.id_asistencia_usuario = id_asistencia_usuario;
    this.cif = cif;
    this.id_evento = id_evento;
  }

  public AsistenciaUsuarioDTO() {
  }

  public Long getId_asistencia_usuario() {
    return id_asistencia_usuario;
  }

  public void setId_asistencia_usuario(Long id_asistencia_usuario) {
    this.id_asistencia_usuario = id_asistencia_usuario;
  }

  public Long getCif() {
    return cif;
  }

  public void setCif(Long cif) {
    this.cif = cif;
  }

  public Long getId_evento() {
    return id_evento;
  }

  public void setId_evento(Long id_evento) {
    this.id_evento = id_evento;
  }
}
