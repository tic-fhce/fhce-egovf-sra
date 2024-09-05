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
@Table(name = "certificados")
public class Certificado {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_certificado", unique = true, nullable = false)
  private Long idCertificado;

  @ManyToOne
  @JoinColumn(name = "_01id_evento")
  private Evento evento;

  @Column(name = "_02carga_horaria")
  private int cargaHoraria;

  @Column(name = "_03tipo")
  private String tipo;

  @Column(name = "_04descripcion")
  private String descripcion;

  @Column(name = "_05estado")
  private int estado = 0;

  @Column(name = "_06modelo")
  private String modelo;

  @Column(name = "_07titulo")
  private String titulo;

  public Certificado(Long idCertificado, Evento evento, int cargaHoraria, String tipo, String descripcion,
      String modelo, String titulo) {
    this.idCertificado = idCertificado;
    this.evento = evento;
    this.cargaHoraria = cargaHoraria;
    this.tipo = tipo;
    this.descripcion = descripcion;
    this.modelo = modelo;
    this.titulo = titulo;
  }

  public Certificado() {
  }

  public Long getIdCertificado() {
    return idCertificado;
  }

  public void setIdCertificado(Long id_certificado) {
    this.idCertificado = id_certificado;
  }

  public int getCargaHoraria() {
    return cargaHoraria;
  }

  public void setCargaHoraria(int carga_horaria) {
    this.cargaHoraria = carga_horaria;
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

  public void setEvento(Evento evento) {
    this.evento = evento;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Evento getEvento() {
    return evento;
  }
}
