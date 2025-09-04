package com.fhce.sra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class inventarioDtoRequest {

    private String nombre;
    private int cantidad;
    private Long idServicio;
    private String codigo;

}
