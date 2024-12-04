package com.example.fhceegovfsra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "ambientes")
public class Ambiente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_ambiente", unique = true, nullable = false)
  private Long idAmbiente;

  @Column(name = "_01nombre")
  private String nombre;

  @Column(name = "_02estado")
  private int estado = 0;

  @Column(name = "_03capacidad")
  private int capacidad;

}
