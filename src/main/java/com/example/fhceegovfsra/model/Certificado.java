package com.example.fhceegovfsra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
