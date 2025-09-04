package com.fhce.sra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ambienteDtoResponse {
	
	private Long id;
    private String nombre;
    private String direccion;
    private int capacidad;

}
