package com.fhce.sra.service;

import java.util.List;

import com.fhce.sra.dto.ambienteDtoRequest;
import com.fhce.sra.dto.ambienteDtoResponse;

public interface ambienteService {
	
	List<ambienteDtoResponse> getListaAmbiente();
    ambienteDtoResponse addAmbiente(ambienteDtoRequest ambienteDtoRequest);
    ambienteDtoResponse updateAmbiente(ambienteDtoResponse ambienteDtoResponse);

}
