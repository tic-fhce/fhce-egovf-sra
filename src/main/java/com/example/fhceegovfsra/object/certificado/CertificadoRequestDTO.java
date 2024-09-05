package com.example.fhceegovfsra.object.certificado;

public class CertificadoRequestDTO {

  private Long idEvento;
  private int cargaHoraria;
  private String tipo;
  private String descripcion;
  private String modelo;
  private String titulo;

  public CertificadoRequestDTO(Long idEvento, int cargaHoraria, String tipo, String descripcion, String modelo,
      String titulo) {
    this.idEvento = idEvento;
    this.cargaHoraria = cargaHoraria;
    this.tipo = tipo;
    this.descripcion = descripcion;
    this.modelo = modelo;
    this.titulo = titulo;
  }

  public CertificadoRequestDTO() {
  }

  public Long getIdEvento() {
    return idEvento;
  }

  public void setIdEvento(Long idEvento) {
    this.idEvento = idEvento;
  }

  public int getCargaHoraria() {
    return cargaHoraria;
  }

  public void setCargaHoraria(int cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

}
