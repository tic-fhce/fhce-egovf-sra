package com.fhce.sra.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ambienteDtoRequest {
	private String nombre;
    private String direccion;
    private int capacidad;

}
