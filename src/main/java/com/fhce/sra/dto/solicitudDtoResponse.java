package com.fhce.sra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class solicitudDtoResponse {
	private Long id;
    private String cite;
    private String fecha;
    private Long idEvento;
    private Long idServicio;
    private String hojaRuta;
    private Long cifResponsable;
    private String detalle;
    private int gestion;

}
