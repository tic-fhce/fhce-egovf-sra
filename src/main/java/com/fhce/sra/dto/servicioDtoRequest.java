package com.fhce.sra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class servicioDtoRequest {
    private String detalle;
    private Long idAmbiente;
    private String nombre;

}
