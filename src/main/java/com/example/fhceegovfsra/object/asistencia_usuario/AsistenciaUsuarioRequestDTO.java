package com.example.fhceegovfsra.object.asistencia_usuario;

public class AsistenciaUsuarioRequestDTO {
  private Long cif;
  private Long idEvento;

  public AsistenciaUsuarioRequestDTO(Long cif, Long idEvento) {
    this.cif = cif;
    this.idEvento = idEvento;
  }

  public AsistenciaUsuarioRequestDTO() {
  }

  public Long getCif() {
    return cif;
  }

  public void setCif(Long cif) {
    this.cif = cif;
  }

  public Long getIdEvento() {
    return idEvento;
  }

  public void setIdEvento(Long idEvento) {
    this.idEvento = idEvento;
  }

}
