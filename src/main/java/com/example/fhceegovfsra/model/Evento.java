package com.example.fhceegovfsra.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "eventos")
public class Evento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_evento", unique = true, nullable = false)
  private Long idEvento;

  @Column(name = "nombre_evento")
  private String nombreEvento;

  @Column(name = "_01cif")
  private Long cif;

  @ManyToOne
  @JoinColumn(name = "_02id_ambiente")
  private Ambiente ambiente;

  @Column(name = "_03cite")
  private String cite = "Pendiente";

  @Column(name = "_04referencia")
  private String referencia = "Pendiente";

  @Column(name = "_05fecha_reserva")
  private LocalDate fechaEvento;

  @Column(name = "_06hora_inicio")
  private LocalTime horaInicio;

  @Column(name = "_07hora_fin")
  private LocalTime horaFin;

  @Column(name = "_08estado")
  private int estado = 0;

  @Column(name = "_09hoja_ruta")
  private String hojaRuta = "Pendiente";

  @Column(name = "_10fecha_actual")
  private LocalDate fechaReserva;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "_011tipo")
  private Tipo tipo;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "requerimientos_eventos", joinColumns = @JoinColumn(name = "id_evento"), inverseJoinColumns = @JoinColumn(name = "id_requerimiento"))
  private List<Requerimiento> requerimientos;
}
