package com.example.fhceegovfsra.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "requerimientos")
public class Requerimiento {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_requerimiento", unique = true, nullable = false)
  private Long idRequerimiento;

  @Column(name = "_01cite")
  private String cite;

  @Column(name = "_02detalle")
  private String detalle;

  @Column(name = "_03estado")
  private int estado = 0;

  @ManyToMany(mappedBy = "requerimientos", fetch = FetchType.LAZY)
  private List<Evento> eventos = new ArrayList<>();

}
