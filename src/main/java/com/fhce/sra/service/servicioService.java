package com.fhce.sra.service;

import java.util.List;

import com.fhce.sra.dto.servicioDtoRequest;
import com.fhce.sra.dto.servicioDtoResponse;

public interface servicioService {
	List<servicioDtoResponse>getListaServicio(Long idAmbiente);
	servicioDtoResponse addServicio(servicioDtoRequest servicioDtoRequest);
	servicioDtoResponse updateServicio(servicioDtoResponse servicioDtoResponse);
	

}
