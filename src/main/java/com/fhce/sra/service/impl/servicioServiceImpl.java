package com.fhce.sra.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fhce.sra.dao.inventarioDao;
import com.fhce.sra.dao.servicioDao;
import com.fhce.sra.dto.inventarioDtoResponse;
import com.fhce.sra.dto.servicioDtoRequest;
import com.fhce.sra.dto.servicioDtoResponse;
import com.fhce.sra.model.servicioModel;
import com.fhce.sra.service.servicioService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class servicioServiceImpl implements servicioService{
	private final servicioDao servicioDao;
	private final inventarioDao inventarioDao;
	private final ModelMapper modelMapper;
	
	@Transactional
    public List<servicioDtoResponse> getListaServicio(Long idAmbiente) {
        List<servicioDtoResponse> servicios = this.servicioDao.getServicio(idAmbiente).stream()
        		.map(servicio->this.modelMapper.map(servicio,servicioDtoResponse.class))
        		.collect(Collectors.toList());
        List<inventarioDtoResponse>equipos = this.inventarioDao.findAll().stream()
        		.map(equipo ->this.modelMapper.map(equipo, inventarioDtoResponse.class))
        		.collect(Collectors.toList());
        
        List<inventarioDtoResponse>inventario;
        for(int i=0; i<servicios.size();i++) {
        	inventario = new ArrayList<inventarioDtoResponse>();
        	for(int j=0;j<equipos.size();j++) {
        		if(servicios.get(i).getId().longValue()==equipos.get(j).getIdServicio().longValue()) {
        			inventario.add(equipos.get(j));
        		}
        	}
        	servicios.get(i).setInventario(inventario);
        }
        return(servicios);
    }
    
    @Transactional
    public servicioDtoResponse addServicio(servicioDtoRequest servicioDtoRequest) {
    	servicioModel servicioModel = new servicioModel();
    	servicioModel.setNombre(servicioDtoRequest.getNombre());
    	servicioModel.setDetalle(servicioDtoRequest.getDetalle());
    	servicioModel.setIdAmbiente(servicioDtoRequest.getIdAmbiente());
    	
    	this.servicioDao.save(servicioModel);
        return(this.modelMapper.map(servicioModel, servicioDtoResponse.class));
    }
    

}
