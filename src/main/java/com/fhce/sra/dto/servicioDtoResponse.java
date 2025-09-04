package com.fhce.sra.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class servicioDtoResponse {
	private Long id;
    private String detalle;
    private Long idAmbiente;
    private String nombre;
    private List<inventarioDtoResponse>inventario;

}
