package com.fhce.sra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "solicitud")
public class solicitudModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
	
	@Column(name = "_01cite")
    private String cite;
	
	@Column(name = "_02fecha")
    private String fecha;
	
	@Column(name = "_03idevento")
    private Long IdEvento;
	
	@Column(name = "_04idservicio")
    private Long idServicio;
	
	@Column(name = "_05hojaruta")
    private String hojaRuta;
	
	@Column(name = "_06cifresponsable")
    private Long cifResponsable;
	
	@Lob
	@Column(name = "_07detalle", columnDefinition = "LONGTEXT")
    private String detalle;
	
	@Column(name = "_08gestion")
    private int gestion;
	
	
}
