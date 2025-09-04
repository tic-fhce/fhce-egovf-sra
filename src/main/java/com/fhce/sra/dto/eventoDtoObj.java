package com.fhce.sra.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class eventoDtoObj {
	private Long id;
	private String nombre;
    private String detalle;
    private String fechaInicio;
    private String fechaFin;
    private String horaInicio;
    private String horaFin;
    private String estado;
    private String ambiente;
    private Long idAmbiente;
    private String imagen;
    private String fecha;
    private String fechaE;
    private String color;
    private String colorCalendar;
    private List<servicioDtoResponse>servicios;

}
