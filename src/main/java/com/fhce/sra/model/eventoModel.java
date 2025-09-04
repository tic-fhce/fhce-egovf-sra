package com.fhce.sra.model;

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
@Table(name = "evento")
public class eventoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	@Column(name = "_01nombre")
    private String nombre;
	
	@Column(name = "_02detalle", columnDefinition = "LONGTEXT")
    private String detalle;
	
	@Column(name = "_03start")
    private String fechaInicio;
	
	@Column(name = "_04end")
    private String fechaFin;
	
	@Column(name = "_05horainicio")
    private String horaInicio;
	
	@Column(name = "_06horafin")
    private String horaFin;
	
	@Column(name = "_07estado")
    private int estado;
	
	@Column(name = "_08idambiente")
    private Long idAmbiente;
	
	@Column(name = "_09imagen")
    private String imagen;
	
	@Column(name = "_10cif")
    private Long cif;
	
	@Column(name = "_11fecha")
    private String fecha;
	
	@Column(name = "_12fecha")
    private String fechae;
	
	@Column(name = "_13unidad")
    private String unidad;
	
}
