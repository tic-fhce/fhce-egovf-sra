package com.example.fhceegovfsra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuario", unique = true, nullable = false)
  private Long idUsuario;

  @Column(name = "_01cif")
  private Long cif;

  public Usuario(Long id_usuario, Long cif) {
    this.idUsuario = id_usuario;
    this.cif = cif;
  }

  public Usuario() {
  }

  public Long getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Long id_usuario) {
    this.idUsuario = id_usuario;
  }

  public Long getCif() {
    return cif;
  }

  public void setCif(Long cif) {
    this.cif = cif;
  }
}
