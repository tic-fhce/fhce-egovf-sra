package com.example.fhceegovfsra.object.usuario;

public class UsuarioDTO {

  private Long id_usuario;
  private Long cif;

  public UsuarioDTO() {
  }

  public UsuarioDTO(Long id_usuario, Long cif) {
    this.id_usuario = id_usuario;
    this.cif = cif;
  }

  public Long getId_usuario() {
    return id_usuario;
  }

  public void setId_usuario(Long id_usuario) {
    this.id_usuario = id_usuario;
  }

  public Long getCif() {
    return cif;
  }

  public void setCif(Long cif) {
    this.cif = cif;
  }

}
