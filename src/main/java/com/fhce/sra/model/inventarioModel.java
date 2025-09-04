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
@Table(name = "inventario")
public class inventarioModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
	
	@Column(name = "_01nombre")
    private String nombre;
	
	@Column(name = "_02cantidad")
    private int cantidad;
	
	@Column(name = "_03idservicio")
    private Long idServicio;
	
	@Column(name = "_04codigo")
    private String codigo;
	

}
