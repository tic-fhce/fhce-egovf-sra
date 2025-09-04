package com.fhce.sra.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fhce.sra.dao.ambienteDao;
import com.fhce.sra.dto.ambienteDtoRequest;
import com.fhce.sra.dto.ambienteDtoResponse;
import com.fhce.sra.model.ambienteModel;
import com.fhce.sra.service.ambienteService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ambienteServiceImpl implements ambienteService{
	
	
    private final ambienteDao ambienteDao;
	private final ModelMapper modelMapper;

	@Transactional
    public List<ambienteDtoResponse> getListaAmbiente() {
        List<ambienteDtoResponse> ambientes = this.ambienteDao.findAll().stream()
        		.map(ambiente->this.modelMapper.map(ambiente,ambienteDtoResponse.class))
        		.collect(Collectors.toList());
        
        return(ambientes);
    }

    @Transactional
    public ambienteDtoResponse addAmbiente(ambienteDtoRequest ambienteDtoRequest) {
        ambienteModel ambienteModel = new ambienteModel();
        
        ambienteModel.setNombre(ambienteDtoRequest.getNombre());
        ambienteModel.setCapacidad(ambienteDtoRequest.getCapacidad());
        ambienteModel.setDireccion(ambienteDtoRequest.getDireccion());
        
        this.ambienteDao.save(ambienteModel);
        return (this.modelMapper.map(ambienteModel, ambienteDtoResponse.class));
    }

    @Transactional
    public ambienteDtoResponse updateAmbiente(ambienteDtoResponse ambienteDtoResponse) {
        
    	ambienteModel ambienteModel = this.modelMapper.map(ambienteDtoResponse, ambienteModel.class);
		this.ambienteDao.save(ambienteModel);
        return (this.modelMapper.map(ambienteModel, ambienteDtoResponse.getClass()));
    }

}
