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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recibe")
public class RecepcionCertificado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_recepcion_certificado", unique = true, nullable = false)
  private Long idRecepcionCertificado;

  @Column(name = "_01cif")
  private Long cif;

  @ManyToOne
  @JoinColumn(name = "_02id_certificado")
  private Certificado certificado;
}
