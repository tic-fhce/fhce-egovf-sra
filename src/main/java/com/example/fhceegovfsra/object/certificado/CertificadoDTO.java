package com.example.fhceegovfsra.object.certificado;

import com.example.fhceegovfsra.object.evento.EventoDTO;

public class CertificadoDTO {
  private Long id_certificado;
  private EventoDTO evento;
  private int carga_horaria;
  private String tipo;
  private String descripcion;
  private int estado;
  private String modelo;
  private String titulo;

  public CertificadoDTO(Long id_certificado, EventoDTO evento, int carga_horaria, String tipo, String descripcion,
      int estado, String modelo, String titulo) {
    this.id_certificado = id_certificado;
    this.evento = evento;
    this.carga_horaria = carga_horaria;
    this.tipo = tipo;
    this.descripcion = descripcion;
    this.estado = estado;
    this.modelo = modelo;
    this.titulo = titulo;
  }

  public CertificadoDTO() {
  }

  public Long getId_certificado() {
    return id_certificado;
  }

  public void setId_certificado(Long id_certificado) {
    this.id_certificado = id_certificado;
  }

  public int getCarga_horaria() {
    return carga_horaria;
  }

  public void setCarga_horaria(int carga_horaria) {
    this.carga_horaria = carga_horaria;
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

  public EventoDTO getEvento() {
    return evento;
  }

  public void setEvento(EventoDTO evento) {
    this.evento = evento;
  }
}
