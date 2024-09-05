package com.example.fhceegovfsra.object.certificado;

public class CertificadoResponseDTO {

  private Long idCertificado;
  private String nombreEvento;
  private int cargaHoraria;
  private String tipo;
  private String descripcion;
  private int estado;
  private String modelo;
  private String titulo;

  public CertificadoResponseDTO(Long idCertificado, String nombreEvento, int cargaHoraria, String tipo,
      String descripcion,
      int estado, String modelo, String titulo) {
    this.idCertificado = idCertificado;
    this.nombreEvento = nombreEvento;
    this.cargaHoraria = cargaHoraria;
    this.tipo = tipo;
    this.descripcion = descripcion;
    this.estado = estado;
    this.modelo = modelo;
    this.titulo = titulo;
  }

  public CertificadoResponseDTO() {
  }

  public Long getIdCertificado() {
    return idCertificado;
  }

  public void setIdCertificado(Long idCertificado) {
    this.idCertificado = idCertificado;
  }

  public String getNombreEvento() {
    return nombreEvento;
  }

  public void setNombreEvento(String nombreEvento) {
    this.nombreEvento = nombreEvento;
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

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
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
