package com.fhce.sra.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fhce.sra.dao.inventarioDao;
import com.fhce.sra.dto.inventarioDtoRequest;
import com.fhce.sra.dto.inventarioDtoResponse;
import com.fhce.sra.dto.servicioDtoRequest;
import com.fhce.sra.dto.servicioDtoResponse;
import com.fhce.sra.model.inventarioModel;
import com.fhce.sra.model.servicioModel;
import com.fhce.sra.service.inventarioService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class inventarioServiceImpl implements inventarioService{
	
	private final inventarioDao inventarioDao;
	private final ModelMapper modelMapper;
	
    @Transactional
    public inventarioDtoResponse addInventario(inventarioDtoRequest inventarioDtoRequest) {
    	inventarioModel inventarioModel = new inventarioModel();
    	
    	inventarioModel.setNombre(inventarioDtoRequest.getNombre());
    	inventarioModel.setCantidad(inventarioDtoRequest.getCantidad());
    	inventarioModel.setCodigo(inventarioDtoRequest.getCodigo());
    	inventarioModel.setIdServicio(inventarioDtoRequest.getIdServicio());
    	    	
    	this.inventarioDao.save(inventarioModel);
        return(this.modelMapper.map(inventarioModel, inventarioDtoResponse.class));
    }	

}
