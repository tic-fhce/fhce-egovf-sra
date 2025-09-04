package com.fhce.sra.service;

import com.fhce.sra.dto.inventarioDtoRequest;
import com.fhce.sra.dto.inventarioDtoResponse;

public interface inventarioService {
	inventarioDtoResponse addInventario(inventarioDtoRequest inventarioDtoRequest);

}
