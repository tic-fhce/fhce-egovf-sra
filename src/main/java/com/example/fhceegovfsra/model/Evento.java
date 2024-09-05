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

  public Evento(Long id_evento, String nombreEvento, Long cif, Ambiente ambiente,
      LocalDate fechaEvento,
      LocalTime horaInicio, LocalTime horaFin, LocalDate fechaReserva, Tipo tipo,
      List<Requerimiento> requerimientos) {
    this.idEvento = id_evento;
    this.nombreEvento = nombreEvento;
    this.idEvento = id_evento;
    this.cif = cif;
    this.ambiente = ambiente;
    this.fechaEvento = fechaEvento;
    this.horaInicio = horaInicio;
    this.horaFin = horaFin;
    this.fechaReserva = fechaReserva;
    this.tipo = tipo;
    this.requerimientos = requerimientos;
  }

  public Evento() {
  }

  public Long getIdEvento() {
    return idEvento;
  }

  public void setIdEvento(Long idEvento) {
    this.idEvento = idEvento;
  }

  public String getNombreEvento() {
    return nombreEvento;
  }

  public void setNombreEvento(String nombreEvento) {
    this.nombreEvento = nombreEvento;
  }

  public Long getCif() {
    return cif;
  }

  public void setCif(Long cif) {
    this.cif = cif;
  }

  public Ambiente getAmbiente() {
    return ambiente;
  }

  public void setAmbiente(Ambiente ambiente) {
    this.ambiente = ambiente;
  }

  public String getCite() {
    return cite;
  }

  public void setCite(String cite) {
    this.cite = cite;
  }

  public String getReferencia() {
    return referencia;
  }

  public void setReferencia(String referencia) {
    this.referencia = referencia;
  }

  public LocalDate getFechaEvento() {
    return fechaEvento;
  }

  public void setFechaEvento(LocalDate fechaEvento) {
    this.fechaEvento = fechaEvento;
  }

  public LocalTime getHoraInicio() {
    return horaInicio;
  }

  public void setHoraInicio(LocalTime horaInicio) {
    this.horaInicio = horaInicio;
  }

  public LocalTime getHoraFin() {
    return horaFin;
  }

  public void setHoraFin(LocalTime horaFin) {
    this.horaFin = horaFin;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

  public String getHojaRuta() {
    return hojaRuta;
  }

  public void setHojaRuta(String hojaRuta) {
    this.hojaRuta = hojaRuta;
  }

  public LocalDate getFechaReserva() {
    return fechaReserva;
  }

  public void setFechaReserva(LocalDate fechaReserva) {
    this.fechaReserva = fechaReserva;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  public List<Requerimiento> getRequerimientos() {
    return requerimientos;
  }

  public void setRequerimientos(List<Requerimiento> requerimientos) {
    this.requerimientos = requerimientos;
  }

}
