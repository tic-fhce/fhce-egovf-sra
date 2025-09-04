package com.fhce.sra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class eventoDtoRequest {
	
    private String nombre;
    private String detalle;
    private String fechaInicio;
    private String fechaFin;
    private String horaInicio;
    private String horaFin;
    private int estado;
    private Long idAmbiente;
    private String imagen; 
    private Long cif;
    private String fecha;
    private String fechaE;
    private String unidad;

}
