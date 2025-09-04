package com.fhce.sra.service;

import java.util.List;

import com.fhce.sra.dto.solicitudDtoObj;
import com.fhce.sra.dto.solicitudDtoRequest;
import com.fhce.sra.dto.solicitudDtoResponse;

public interface solicitudService {
	List<solicitudDtoResponse> getListaSolicitud();
	solicitudDtoResponse addSolicitud(solicitudDtoRequest solicitudDtoRequest);
	solicitudDtoResponse updateSolicitud(solicitudDtoResponse solicitudDtoResponse);
	List<solicitudDtoObj> getSolicitudes(int estado);
	List<solicitudDtoObj> getSolicitudesUnidad(int estado,String unidad);
	List<solicitudDtoObj> getSolicitudesEventos();
	List<solicitudDtoObj> getSolicitudesEventosUnidad(String unidad);
	 List<solicitudDtoObj> getLista(int gestion,int mes);
	 List<solicitudDtoObj> getListaUsuario(int gestion,int mes,String sigla);

}
