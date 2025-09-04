package com.fhce.sra.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fhce.sra.dao.ambienteDao;
import com.fhce.sra.dao.eventoDao;
import com.fhce.sra.dao.servicioDao;
import com.fhce.sra.dto.eventoDtoObj;
import com.fhce.sra.dto.eventoDtoRequest;
import com.fhce.sra.dto.eventoDtoResponse;
import com.fhce.sra.dto.servicioDtoResponse;
import com.fhce.sra.model.ambienteModel;
import com.fhce.sra.model.eventoModel;
import com.fhce.sra.service.eventoService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class eventoServiceImpl implements eventoService{
	
	private final eventoDao eventoDao;
	private final ambienteDao ambienteDao;
	private final ModelMapper modelMapper;
	private final servicioDao servicioDao;

	@Transactional
    public List<eventoDtoObj> getListaEventos() {
    	
    	LocalDate fecha;
    	LocalDateTime fechaHoraActual = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = fechaHoraActual.format(formatter);
        
        LocalDate fechaActual = LocalDate.now();
        
        List<eventoDtoResponse> eventos = this.eventoDao.getFecha(fechaActual).stream()
        		.map(evento->this.modelMapper.map(evento,eventoDtoResponse.class))
        		.collect(Collectors.toList());
        
        	
        List<ambienteModel> ambiente = this.ambienteDao.findAll();
        
        List<eventoDtoObj>actual = new ArrayList<eventoDtoObj>();
        
        eventoDtoObj eventoDtoObj;
        String nombreAmbiente="";
        Long idAmbiente=(long)0;
        for(int i=0; i<eventos.size();i++) {
        	for(int j=0;j<ambiente.size();j++) {
        		if(eventos.get(i).getIdAmbiente().longValue()==ambiente.get(j).getId().longValue()) {
        			nombreAmbiente = ambiente.get(j).getNombre();
        			idAmbiente=ambiente.get(j).getId();
        			break;
        		}
        	}
        	
        	
        	if(eventos.get(i).getEstado()<2) {
        		eventoDtoObj = new eventoDtoObj();
        		eventoDtoObj.setId(eventos.get(i).getId());
        		eventoDtoObj.setNombre(eventos.get(i).getNombre());
        		eventoDtoObj.setDetalle(eventos.get(i).getDetalle());
        		eventoDtoObj.setFechaInicio(eventos.get(i).getFechaInicio());
        		eventoDtoObj.setFechaFin(eventos.get(i).getFechaFin());
        		eventoDtoObj.setHoraInicio(eventos.get(i).getHoraInicio()); 
        		eventoDtoObj.setHoraFin(eventos.get(i).getHoraFin());
        		
        		eventoDtoObj.setAmbiente(nombreAmbiente);
        		eventoDtoObj.setIdAmbiente(idAmbiente);
        		eventoDtoObj.setImagen(eventos.get(i).getImagen());
        		eventoDtoObj.setFecha(eventos.get(i).getFecha());
        		eventoDtoObj.setFechaE(eventos.get(i).getFechaE()); 
        		
        		if(eventos.get(i).getEstado()==0) {
        			eventoDtoObj.setColor("warning");
            		eventoDtoObj.setColorCalendar("#bf9000");
            		eventoDtoObj.setEstado("En Espera");
        		}
        		if(eventos.get(i).getEstado()==1) {
        			eventoDtoObj.setColor("success");
            		eventoDtoObj.setColorCalendar("#339900");
            		eventoDtoObj.setEstado("Aprobado");
        		}
        		if(eventos.get(i).getEstado()==2) {
        			eventoDtoObj.setColor("danger");
            		eventoDtoObj.setColorCalendar("#cc0000");
            		eventoDtoObj.setEstado("Cancelado");
        		}
        			
        		actual.add(eventoDtoObj);
        	}
        }
        
        return(actual);
    }

    @Transactional
    public eventoDtoResponse addEvento(eventoDtoRequest eventoDtoRequest) {
        
    	LocalDateTime fechaHoraActual = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = fechaHoraActual.format(formatter);
    	
    	eventoModel eventoModel = new eventoModel();
    	
        eventoModel.setNombre(eventoDtoRequest.getNombre());
        eventoModel.setDetalle(eventoDtoRequest.getDetalle());
        eventoModel.setFechaInicio(eventoDtoRequest.getFechaInicio());
        eventoModel.setFechaFin(eventoDtoRequest.getFechaFin());
        eventoModel.setHoraInicio(eventoDtoRequest.getHoraInicio());
        eventoModel.setHoraFin(eventoDtoRequest.getHoraFin());
        eventoModel.setEstado(0);
        eventoModel.setIdAmbiente(eventoDtoRequest.getIdAmbiente());
        eventoModel.setImagen(eventoDtoRequest.getImagen());
        eventoModel.setCif(eventoDtoRequest.getCif());
        eventoModel.setFecha(fechaFormateada);
        eventoModel.setFechae(fechaFormateada);
        eventoModel.setUnidad(eventoDtoRequest.getUnidad());
        
        this.eventoDao.save(eventoModel);
        return (this.modelMapper.map(eventoModel, eventoDtoResponse.class));
    }
    
    @Transactional
    public eventoDtoResponse updateEvento(eventoDtoResponse eventoDtoResponse) {
        
    	LocalDateTime fechaHoraActual = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = fechaHoraActual.format(formatter);
    	
    	eventoModel evento = this.modelMapper.map(eventoDtoResponse, eventoModel.class);
    	
    	evento.setFechae(fechaFormateada);
		this.eventoDao.save(evento);
        return (this.modelMapper.map(evento, eventoDtoResponse.getClass()));
    }
    
    @Transactional
    public List<eventoDtoObj> getListaEventoAmbiente(int gestion, Long idAmbiente) {
    	
    	LocalDate fecha;
    	eventoDtoObj eventoDtoObj;
    	ambienteModel ambienteModel = this.ambienteDao.getAmbiente(idAmbiente);
        List<eventoDtoResponse> eventos = this.eventoDao.findAll().stream()
        		.map(evento->this.modelMapper.map(evento,eventoDtoResponse.class))
        		.collect(Collectors.toList());
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        List<eventoDtoObj>actual = new ArrayList<eventoDtoObj>();
        for(int i=0; i<eventos.size();i++) {
        	
        	fecha = LocalDate.parse(eventos.get(i).getFechaInicio(), formatter);
        	
        	if(gestion == fecha.getYear() && idAmbiente.longValue()==eventos.get(i).getIdAmbiente().longValue()) {
        		eventoDtoObj = new eventoDtoObj();
        		eventoDtoObj.setId(eventos.get(i).getId());
        		eventoDtoObj.setNombre(eventos.get(i).getNombre());
        		eventoDtoObj.setDetalle(eventos.get(i).getDetalle());
        		eventoDtoObj.setFechaInicio(eventos.get(i).getFechaInicio());
        		eventoDtoObj.setFechaFin(eventos.get(i).getFechaFin());
        		eventoDtoObj.setHoraInicio(eventos.get(i).getHoraInicio()); 
        		eventoDtoObj.setHoraFin(eventos.get(i).getHoraFin());
        		
        		eventoDtoObj.setAmbiente(ambienteModel.getNombre());
        		eventoDtoObj.setIdAmbiente(idAmbiente);
        		eventoDtoObj.setImagen(eventos.get(i).getImagen());
        		eventoDtoObj.setFecha(eventos.get(i).getFecha());
        		eventoDtoObj.setFechaE(eventos.get(i).getFechaE()); 
        		
        		if(eventos.get(i).getEstado()==0) {
        			eventoDtoObj.setColor("warning");
            		eventoDtoObj.setColorCalendar("#bf9000");
            		eventoDtoObj.setEstado("En Espera");
        		}
        		if(eventos.get(i).getEstado()==1) {
        			eventoDtoObj.setColor("success");
            		eventoDtoObj.setColorCalendar("#339900");
            		eventoDtoObj.setEstado("Aprobado");
        		}
        		if(eventos.get(i).getEstado()==2) {
        			eventoDtoObj.setColor("danger");
            		eventoDtoObj.setColorCalendar("#cc0000");
            		eventoDtoObj.setEstado("Cancelado");
        		}
        			
        		actual.add(eventoDtoObj);
        	}
        	
        }
        
        return(actual);
    }
    @Transactional
    public eventoDtoObj getEvento(Long idEvento) {
    	eventoModel eventoModel = this.eventoDao.getEvento(idEvento);
    	eventoDtoObj eventoDtoObj = new eventoDtoObj();
    	if(eventoModel == null) {
    		eventoDtoObj.setId((long) 0);
    	}
    	else {
    		ambienteModel ambienteModel = this.ambienteDao.getAmbiente(eventoModel.getIdAmbiente());
    		List<servicioDtoResponse> servicios = this.servicioDao.getServicio(eventoModel.getIdAmbiente()).stream()
    				.map(servicio->this.modelMapper.map(servicio, servicioDtoResponse.class))
    				.collect(Collectors.toList());
    		
    		eventoDtoObj.setId(eventoModel.getId());
    		eventoDtoObj.setNombre(eventoModel.getNombre());
    		eventoDtoObj.setDetalle(eventoModel.getDetalle());
    		eventoDtoObj.setFechaInicio(eventoModel.getFechaInicio());
    		eventoDtoObj.setFechaFin(eventoModel.getFechaFin());
    		eventoDtoObj.setHoraInicio(eventoModel.getHoraInicio()); 
    		eventoDtoObj.setHoraFin(eventoModel.getHoraFin());
    		
    		eventoDtoObj.setAmbiente(ambienteModel.getNombre());
    		eventoDtoObj.setIdAmbiente(ambienteModel.getId());
    		eventoDtoObj.setImagen(eventoModel.getImagen());
    		eventoDtoObj.setFecha(eventoModel.getFecha());
    		eventoDtoObj.setFechaE(eventoModel.getFechae());
    		eventoDtoObj.setServicios(servicios);
    		
    		if(eventoModel.getEstado()==0) {
    			eventoDtoObj.setColor("warning");
        		eventoDtoObj.setColorCalendar("#bf9000");
        		eventoDtoObj.setEstado("En Espera");
    		}
    		if(eventoModel.getEstado()==1) {
    			eventoDtoObj.setColor("success");
        		eventoDtoObj.setColorCalendar("#339900");
        		eventoDtoObj.setEstado("Aprobado");
    		}
    		if(eventoModel.getEstado()==2) {
    			eventoDtoObj.setColor("danger");
        		eventoDtoObj.setColorCalendar("#cc0000");
        		eventoDtoObj.setEstado("Cancelado");
    		}
    	}
    	return(eventoDtoObj);
    }
    
    @Transactional
    public List<eventoDtoObj> getEventoUnidad(String unidad,String fecha) {
    	List<eventoModel> eventoModel = this.eventoDao.getEventoUnidad(unidad,fecha+"-01",fecha+"-31");
    	eventoDtoObj eventoDtoObj;
    	
    	List<eventoDtoObj>eventos = new ArrayList<eventoDtoObj>();
    	ambienteModel ambienteModel;
    	List<servicioDtoResponse> servicios;
    	
    	for(int i=0; i<eventoModel.size();i++) {
    		ambienteModel = this.ambienteDao.getAmbiente(eventoModel.get(i).getIdAmbiente());
    		
    		servicios = this.servicioDao.getServicio(eventoModel.get(i).getIdAmbiente()).stream()
    				.map(servicio->this.modelMapper.map(servicio, servicioDtoResponse.class))
    				.collect(Collectors.toList());
    		
    		eventoDtoObj = new eventoDtoObj();
    		eventoDtoObj.setId(eventoModel.get(i).getId());
    		eventoDtoObj.setNombre(eventoModel.get(i).getNombre());
    		eventoDtoObj.setDetalle(eventoModel.get(i).getDetalle());
    		eventoDtoObj.setFechaInicio(eventoModel.get(i).getFechaInicio());
    		eventoDtoObj.setFechaFin(eventoModel.get(i).getFechaFin());
    		eventoDtoObj.setHoraInicio(eventoModel.get(i).getHoraInicio()); 
    		eventoDtoObj.setHoraFin(eventoModel.get(i).getHoraFin());
    		
    		eventoDtoObj.setAmbiente(ambienteModel.getNombre());
    		eventoDtoObj.setIdAmbiente(ambienteModel.getId());
    		eventoDtoObj.setImagen(eventoModel.get(i).getImagen());
    		eventoDtoObj.setFecha(eventoModel.get(i).getFecha());
    		eventoDtoObj.setFechaE(eventoModel.get(i).getFechae());
    		eventoDtoObj.setServicios(servicios);
    		
    		if(eventoModel.get(i).getEstado()==0) {
    			eventoDtoObj.setColor("warning");
        		eventoDtoObj.setColorCalendar("#bf9000");
        		eventoDtoObj.setEstado("En Espera");
    		}
    		if(eventoModel.get(i).getEstado()==1) {
    			eventoDtoObj.setColor("success");
        		eventoDtoObj.setColorCalendar("#339900");
        		eventoDtoObj.setEstado("Aprobado");
    		}
    		if(eventoModel.get(i).getEstado()==2) {
    			eventoDtoObj.setColor("danger");
        		eventoDtoObj.setColorCalendar("#cc0000");
        		eventoDtoObj.setEstado("Cancelado");
    		}
    		eventos.add(eventoDtoObj);
    		
    	}
    	
    	return(eventos);
    }

}
