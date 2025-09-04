package com.fhce.sra.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class solicitudDtoObj {

	private Long idSolicitud;
    private String cite;
    private String fecha;
    
    private eventoDtoObj evento;
    
    private Long idAmbiente;
    private String ambiente;
    private Long idServicio;
    private String servicio;
    private String hojaRuta;
    private Long cifResponsable;
    private String detalle;
    private int gestion;
    private String color;
    private String total;
}
