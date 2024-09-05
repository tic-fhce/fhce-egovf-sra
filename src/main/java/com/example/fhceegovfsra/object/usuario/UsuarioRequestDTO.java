package com.example.fhceegovfsra.object.usuario;

public class UsuarioRequestDTO {
  private Long cif;

  public UsuarioRequestDTO(Long cif) {
    this.cif = cif;
  }

  public UsuarioRequestDTO() {
  }

  public Long getCif() {
    return cif;
  }

  public void setCif(Long cif) {
    this.cif = cif;
  }

}
