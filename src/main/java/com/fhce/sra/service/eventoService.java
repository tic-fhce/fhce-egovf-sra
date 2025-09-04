package com.fhce.sra.service;

import java.util.List;

import com.fhce.sra.dto.eventoDtoObj;
import com.fhce.sra.dto.eventoDtoRequest;
import com.fhce.sra.dto.eventoDtoResponse;

public interface eventoService {
	
	List<eventoDtoObj> getListaEventos();
    eventoDtoResponse addEvento(eventoDtoRequest eventoDtoRequest);
    eventoDtoResponse updateEvento(eventoDtoResponse eventoDtoResponse);
    List<eventoDtoObj> getListaEventoAmbiente(int gestion, Long idAmbiente);
    eventoDtoObj getEvento(Long idEvento);
    List<eventoDtoObj> getEventoUnidad(String unidad,String fecha);

}
