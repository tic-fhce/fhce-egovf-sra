package com.fhce.sra.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fhce.sra.dao.ambienteDao;
import com.fhce.sra.dao.eventoDao;
import com.fhce.sra.dao.servicioDao;
import com.fhce.sra.dao.solicitudDao;
import com.fhce.sra.dto.eventoDtoObj;
import com.fhce.sra.dto.servicioDtoResponse;
import com.fhce.sra.dto.solicitudDtoObj;
import com.fhce.sra.dto.solicitudDtoRequest;
import com.fhce.sra.dto.solicitudDtoResponse;
import com.fhce.sra.model.ambienteModel;
import com.fhce.sra.model.eventoModel;
import com.fhce.sra.model.servicioModel;
import com.fhce.sra.model.solicitudModel;
import com.fhce.sra.service.solicitudService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class solicitudSeriviceImpl implements solicitudService{
	
	private final solicitudDao solicitudDao;
	private final eventoDao eventoDao;
	private final ambienteDao ambienteDao;
	private final servicioDao servicioDao;
	private final ModelMapper modelMapper;
	@Transactional
    public List<solicitudDtoResponse> getListaSolicitud() {
        List<solicitudDtoResponse> solicitudes = this.solicitudDao.findAll().stream()
        		.map(solicitud->this.modelMapper.map(solicitud,solicitudDtoResponse.class))
        		.collect(Collectors.toList());
        
        return(solicitudes);
    }
    
    
    @Transactional
    public solicitudDtoResponse addSolicitud(solicitudDtoRequest solicitudDtoRequest) {
    	
    	LocalDateTime fechaHoraActual = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = fechaHoraActual.format(formatter);
    	
    	solicitudModel solicitudModel = new solicitudModel();
    	solicitudModel.setFecha(fechaFormateada);
    	solicitudModel.setIdEvento(solicitudDtoRequest.getIdEvento());
    	solicitudModel.setHojaRuta("#");
    	solicitudModel.setIdServicio(solicitudDtoRequest.getIdServicio());
    	solicitudModel.setCifResponsable(solicitudDtoRequest.getCifResponsable());
    	solicitudModel.setDetalle(solicitudDtoRequest.getDetalle());
    	solicitudModel.setGestion(fechaHoraActual.getYear());
        
        solicitudModel.setCite("FHCE.SRA.NOTA."+cite(solicitudModel.getGestion())+"/"+solicitudModel.getGestion());
        
        this.solicitudDao.save(solicitudModel);
        
        return(this.modelMapper.map(solicitudModel, solicitudDtoResponse.class));
    }
    @Transactional
    public solicitudDtoResponse updateSolicitud(solicitudDtoResponse solicitudDtoResponse) {
    	
    	solicitudModel solicitud;
    	if(solicitudDtoResponse.getHojaRuta().equals("CANCELADO")) {
    		solicitud = this.solicitudDao.getSolicitud(solicitudDtoResponse.getId());
    		eventoModel eventoModel = this.eventoDao.getEvento(solicitud.getIdEvento());
    		eventoModel.setEstado(2);
    		solicitud.setHojaRuta("CANCELADO");
    		this.eventoDao.save(eventoModel);
    		this.solicitudDao.save(solicitud);
    	}
    	else {
    		
    	
	    	solicitud = this.modelMapper.map(solicitudDtoResponse, solicitudModel.class);
	        this.solicitudDao.save(solicitud);
	        
	        eventoModel eventoModel;
	        if(!solicitudDtoResponse.getHojaRuta().equals("#")) { //si la hoja de ruta es diferente de # se aprueba el evento
	        	eventoModel = this.eventoDao.getEvento(solicitudDtoResponse.getIdEvento());
	        	eventoModel.setEstado(1);
	        	this.eventoDao.save(eventoModel);
	        }
	        
	        if(solicitudDtoResponse.getHojaRuta().equals("Cancelado")) { //si la hoa de Ruta es cancelado el evento se cancela
	        	eventoModel = this.eventoDao.getEvento(solicitudDtoResponse.getIdEvento());
	        	eventoModel.setEstado(2);
	        	this.eventoDao.save(eventoModel);
	        }
    	}
        
        return(this.modelMapper.map(solicitud, solicitudDtoResponse.class));
    }
    
    @Transactional
    public List<solicitudDtoObj> getSolicitudes(int estado) {
        //Lista de todos los Ambientes
        List<ambienteModel>ambientes = this.ambienteDao.findAll();
        //Lista de todos los Servicios 
        List<servicioModel>servicios = this.servicioDao.findAll();
        
        //Condiciones para las Solicitudes
    	String hoja="";
    	if(estado==0)
    		hoja = "%#%";
    	if(estado ==1)
    		hoja = "%FHCE%";
    	if(estado == 2)
    		hoja = "CANCELADO";
    	
        List<solicitudModel> solicitudes = this.solicitudDao.getSolicitudHr(hoja);
        
        //Condiciones para los Eventos
        List<eventoModel>estadoEventos = this.eventoDao.getEventoEstado(estado);        
        List<eventoModel>eventos;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        if(estado==1) {
        	LocalDate fechaActual = LocalDate.now();
        	
        	eventos = estadoEventos.stream()
        			.filter(fecha -> {
        				LocalDate f = LocalDate.parse(fecha.getFechaInicio(), formatter);
                        return !f.isBefore(fechaActual);
             })
             .collect(Collectors.toList());
        }
        else {
        	eventos = estadoEventos;
        }
        
        
        List<solicitudDtoObj> solicitudObj = new ArrayList<solicitudDtoObj>();
        
        
        solicitudDtoObj solicitudDtoObj; 
        for(int i=0; i<solicitudes.size();i++) {
        	for(int j=0;j<eventos.size();j++) {
        		
        		if(solicitudes.get(i).getIdEvento().longValue()==eventos.get(j).getId().longValue()) {
        			solicitudDtoObj = new solicitudDtoObj();
        			        			
        			solicitudDtoObj.setIdSolicitud(solicitudes.get(i).getId());
        			solicitudDtoObj.setCite(solicitudes.get(i).getCite());
        			solicitudDtoObj.setFecha(solicitudes.get(i).getFecha());
        			
        			solicitudDtoObj.setEvento(evento(eventos,j,""));
        			solicitudDtoObj.setIdAmbiente(eventos.get(j).getIdAmbiente());
        			
        			solicitudDtoObj.setAmbiente("");
        			solicitudDtoObj.setIdServicio(solicitudes.get(i).getIdServicio());
        			solicitudDtoObj.setServicio("");
        			solicitudDtoObj.setHojaRuta(solicitudes.get(i).getHojaRuta()); 
        			solicitudDtoObj.setCifResponsable(solicitudes.get(i).getCifResponsable());
        			solicitudDtoObj.setDetalle(solicitudes.get(i).getDetalle());
        			solicitudDtoObj.setGestion(solicitudes.get(i).getGestion());
        			
        			solicitudObj.add(solicitudDtoObj);
        			break;
        		}
        	}
        	
        }
       
        
        for(int i=0;i<solicitudObj.size();i++) {
        	for(int j=0;j<ambientes.size();j++) {
        		if(solicitudObj.get(i).getIdAmbiente().longValue()==ambientes.get(j).getId().longValue()) {
        			solicitudObj.get(i).setAmbiente(ambientes.get(j).getNombre());
        			solicitudObj.get(i).getEvento().setAmbiente(ambientes.get(j).getNombre());
        			break;
        		}
        	}
        }
        
        for(int i=0;i<solicitudObj.size();i++) {
        	for(int j=0;j<servicios.size();j++) {
        		if(solicitudObj.get(i).getIdServicio().longValue()== servicios.get(j).getId().longValue()) {
        			solicitudObj.get(i).setServicio(servicios.get(j).getDetalle());
        			break;
        		}
        	}
        }
        
        return(solicitudObj);
    }
    @Transactional
    public List<solicitudDtoObj> getSolicitudesUnidad(int estado,String unidad) {
        //Lista de todos los Ambientes
        List<ambienteModel>ambientes = this.ambienteDao.findAll();
        //Lista de todos los Servicios 
        List<servicioModel>servicios = this.servicioDao.findAll();
        
        //Condiciones para las Solicitudes
    	String hoja="";
    	if(estado==0)
    		hoja = "%#%";
    	if(estado ==1)
    		hoja = "%FHCE%";
    	if(estado == 2)
    		hoja = "CANCELADO";
    	
        List<solicitudModel> solicitudes = this.solicitudDao.getSolicitudHr(hoja);
        LocalDate fechaActual = LocalDate.now();
        
        //Condiciones para los Eventos
        List<eventoModel>eventos = this.eventoDao.getEventoEstadoUnidad(estado,unidad,fechaActual);        
        
        List<solicitudDtoObj> solicitudObj = new ArrayList<solicitudDtoObj>();
        
        
        solicitudDtoObj solicitudDtoObj; 
        for(int i=0; i<solicitudes.size();i++) {
        	for(int j=0;j<eventos.size();j++) {
        		
        		if(solicitudes.get(i).getIdEvento().longValue()==eventos.get(j).getId().longValue()) {
        			solicitudDtoObj = new solicitudDtoObj();
        			        			
        			solicitudDtoObj.setIdSolicitud(solicitudes.get(i).getId());
        			solicitudDtoObj.setCite(solicitudes.get(i).getCite());
        			solicitudDtoObj.setFecha(solicitudes.get(i).getFecha());
        			
        			solicitudDtoObj.setEvento(evento(eventos,j,""));
        			solicitudDtoObj.setIdAmbiente(eventos.get(j).getIdAmbiente());
        			
        			solicitudDtoObj.setAmbiente("");
        			solicitudDtoObj.setIdServicio(solicitudes.get(i).getIdServicio());
        			solicitudDtoObj.setServicio("");
        			solicitudDtoObj.setHojaRuta(solicitudes.get(i).getHojaRuta()); 
        			solicitudDtoObj.setCifResponsable(solicitudes.get(i).getCifResponsable());
        			solicitudDtoObj.setDetalle(solicitudes.get(i).getDetalle());
        			solicitudDtoObj.setGestion(solicitudes.get(i).getGestion());
        			
        			solicitudObj.add(solicitudDtoObj);
        			break;
        		}
        	}
        	
        }
       
        
        for(int i=0;i<solicitudObj.size();i++) {
        	for(int j=0;j<ambientes.size();j++) {
        		if(solicitudObj.get(i).getIdAmbiente().longValue()==ambientes.get(j).getId().longValue()) {
        			solicitudObj.get(i).setAmbiente(ambientes.get(j).getNombre());
        			solicitudObj.get(i).getEvento().setAmbiente(ambientes.get(j).getNombre());
        			break;
        		}
        	}
        }
        
        for(int i=0;i<solicitudObj.size();i++) {
        	for(int j=0;j<servicios.size();j++) {
        		if(solicitudObj.get(i).getIdServicio().longValue()== servicios.get(j).getId().longValue()) {
        			solicitudObj.get(i).setServicio(servicios.get(j).getDetalle());
        			break;
        		}
        	}
        }
        
        return(solicitudObj);
    }
    @Transactional
    public List<solicitudDtoObj> getSolicitudesEventos() {
        
        //Lista de todos los ambientes
    	List<ambienteModel>ambientes = this.ambienteDao.findAll();
    	//Lista de todos los servicios
        List<servicioModel>servicios = this.servicioDao.findAll();
        //Lista de todas las Solicitudes
        List<solicitudModel> solicitudes = this.solicitudDao.findAll();
        
        //Condiciones para los Eventos
        List<eventoModel>eventos = this.eventoDao.findAll();
        Set<Long> idsSolicitudes = solicitudes.stream()
                .map(solicitudModel::getIdEvento)
                .collect(Collectors.toSet());
        
        List<eventoModel>eventosC = eventos.stream()
        		.filter(evento -> !idsSolicitudes.contains(evento.getId()))
        		.collect(Collectors.toList());
        
        List<solicitudDtoObj> solicitudObj = new ArrayList<solicitudDtoObj>();
              
        solicitudDtoObj solicitudDtoObj; 
        for(int i=0; i<eventosC.size();i++) {
        	
        	solicitudDtoObj = new solicitudDtoObj();
        	solicitudDtoObj.setIdSolicitud((long)0);
        	solicitudDtoObj.setCite("");
        	solicitudDtoObj.setFecha("");
        			
        	solicitudDtoObj.setEvento(evento(eventosC,i,""));
        	solicitudDtoObj.setIdAmbiente(eventosC.get(i).getIdAmbiente());
        	solicitudDtoObj.setAmbiente("");
        	solicitudDtoObj.setIdServicio((long)0);
        	solicitudDtoObj.setServicio("");
        	solicitudDtoObj.setHojaRuta(""); 
        	solicitudDtoObj.setCifResponsable((long)0);
        	solicitudDtoObj.setDetalle("");
        	solicitudDtoObj.setGestion(2025);
        			
        	solicitudObj.add(solicitudDtoObj);
        }
        
        for(int i=0;i<solicitudObj.size();i++) {
        	for(int j=0;j<ambientes.size();j++) {
        		if(solicitudObj.get(i).getIdAmbiente().longValue()==ambientes.get(j).getId().longValue()) {
        			solicitudObj.get(i).setAmbiente(ambientes.get(j).getNombre());
        			solicitudObj.get(i).getEvento().setAmbiente(ambientes.get(j).getNombre());
        			break;
        		}
        	}
        }
        
        for(int i=0;i<solicitudObj.size();i++) {
        	for(int j=0;j<servicios.size();j++) {
        		if(solicitudObj.get(i).getIdServicio().longValue()== servicios.get(j).getId().longValue()) {
        			solicitudObj.get(i).setServicio(servicios.get(j).getDetalle());
        			break;
        		}
        	}
        }
        
        return(solicitudObj);
    }
    
    @Transactional
    public List<solicitudDtoObj> getSolicitudesEventosUnidad(String unidad) {
        
        //Lista de todos los ambientes
    	List<ambienteModel>ambientes = this.ambienteDao.findAll();
    	//Lista de todos los servicios
        List<servicioModel>servicios = this.servicioDao.findAll();
        //Lista de todas las Solicitudes
        List<solicitudModel> solicitudes = this.solicitudDao.findAll();
        
        //Condiciones para los Eventos
        List<eventoModel>eventos = this.eventoDao.getUnidad(unidad);
        
        Set<Long> idsSolicitudes = solicitudes.stream()
                .map(solicitudModel::getIdEvento)
                .collect(Collectors.toSet());
        
        List<eventoModel>eventosC = eventos.stream()
        		.filter(evento -> !idsSolicitudes.contains(evento.getId()))
        		.collect(Collectors.toList());
        
        List<solicitudDtoObj> solicitudObj = new ArrayList<solicitudDtoObj>();
              
        solicitudDtoObj solicitudDtoObj; 
        for(int i=0; i<eventosC.size();i++) {
        	
        	solicitudDtoObj = new solicitudDtoObj();
        	solicitudDtoObj.setIdSolicitud((long)0);
        	solicitudDtoObj.setCite("");
        	solicitudDtoObj.setFecha("");
        			
        	solicitudDtoObj.setEvento(evento(eventosC,i,""));
        	solicitudDtoObj.setIdAmbiente(eventosC.get(i).getIdAmbiente());
        	solicitudDtoObj.setAmbiente("");
        	solicitudDtoObj.setIdServicio((long)0);
        	solicitudDtoObj.setServicio("");
        	solicitudDtoObj.setHojaRuta(""); 
        	solicitudDtoObj.setCifResponsable((long)0);
        	solicitudDtoObj.setDetalle("");
        	solicitudDtoObj.setGestion(2025);
        			
        	solicitudObj.add(solicitudDtoObj);
        }
        
        for(int i=0;i<solicitudObj.size();i++) {
        	for(int j=0;j<ambientes.size();j++) {
        		if(solicitudObj.get(i).getIdAmbiente().longValue()==ambientes.get(j).getId().longValue()) {
        			solicitudObj.get(i).setAmbiente(ambientes.get(j).getNombre());
        			solicitudObj.get(i).getEvento().setAmbiente(ambientes.get(j).getNombre());
        			break;
        		}
        	}
        }
        
        for(int i=0;i<solicitudObj.size();i++) {
        	for(int j=0;j<servicios.size();j++) {
        		if(solicitudObj.get(i).getIdServicio().longValue()== servicios.get(j).getId().longValue()) {
        			solicitudObj.get(i).setServicio(servicios.get(j).getDetalle());
        			break;
        		}
        	}
        }
        
        return(solicitudObj);
    }
    
    @Transactional
    public List<solicitudDtoObj> getLista(int gestion,int mes) {
        
        List<ambienteModel>ambientes = this.ambienteDao.findAll();
        List<servicioModel>servicios = this.servicioDao.findAll();
        String m=""+mes;
        if(mes<10)
        	m="0"+mes;
        
        String inicio=gestion+"-"+m+"-01";
        String fin =gestion+"-"+m+"-31";
        List<solicitudModel> solicitudes = this.solicitudDao.getSolicitudGestion(gestion);
        //Condiciones para los Eventos
        List<eventoModel>eventos = this.eventoDao.getFecha(inicio,fin);        
        List<solicitudDtoObj> solicitudObj = new ArrayList<solicitudDtoObj>();

        solicitudDtoObj solicitudDtoObj; 
        for(int i=0; i<eventos.size();i++) {
        	solicitudDtoObj = new solicitudDtoObj();
						
			solicitudDtoObj.setEvento(evento(eventos,i,""));
			solicitudDtoObj.setIdAmbiente(eventos.get(i).getIdAmbiente());
			solicitudDtoObj.setAmbiente("");
			solicitudDtoObj.setServicio("");
			for(int j=0;j<solicitudes.size();j++) {
        		if(solicitudes.get(j).getIdEvento().longValue()==eventos.get(i).getId().longValue()) {
        			solicitudDtoObj.setIdSolicitud(solicitudes.get(j).getId());
        			solicitudDtoObj.setCite(solicitudes.get(j).getCite());
        			solicitudDtoObj.setFecha(solicitudes.get(j).getFecha());
        			solicitudDtoObj.setIdServicio(solicitudes.get(j).getIdServicio());
        			solicitudDtoObj.setHojaRuta(solicitudes.get(j).getHojaRuta()); 
        			solicitudDtoObj.setCifResponsable(solicitudes.get(j).getCifResponsable());
        			solicitudDtoObj.setDetalle(solicitudes.get(j).getDetalle());
        			solicitudDtoObj.setGestion(solicitudes.get(j).getGestion());
        			
        			break;
        		}
        	}
        	solicitudObj.add(solicitudDtoObj);
        	
        }
        
        for(int i=0;i<solicitudObj.size();i++) {
        	for(int j=0;j<ambientes.size();j++) {
        		if(solicitudObj.get(i).getIdAmbiente().longValue()==ambientes.get(j).getId().longValue()) {
        			solicitudObj.get(i).setAmbiente(ambientes.get(j).getNombre());
        			solicitudObj.get(i).getEvento().setAmbiente(ambientes.get(j).getNombre());
        			break;
        		}
        	}
        }
        
        for(int i=0;i<solicitudObj.size();i++) {
        	for(int j=0;j<servicios.size();j++) {
        		if(solicitudObj.get(i).getIdServicio().longValue()== servicios.get(j).getId().longValue()) {
        			solicitudObj.get(i).setServicio(servicios.get(j).getDetalle());
        			break;
        		}
        	}
        }
        
        return(solicitudObj);
    }
    
    @Transactional
    public List<solicitudDtoObj> getListaUsuario(int gestion,int mes,String sigla) {
        
        List<ambienteModel>ambientes = this.ambienteDao.findAll();
        List<servicioModel>servicios = this.servicioDao.findAll();
        String m=""+mes;
        if(mes<10)
        	m="0"+mes;
        
        String inicio=gestion+"-"+m+"-01";
        String fin =gestion+"-"+m+"-31";
        List<solicitudModel> solicitudes = this.solicitudDao.getSolicitudGestion(gestion);
        //Condiciones para los Eventos
        List<eventoModel>eventos = this.eventoDao.getEventoUnidad(sigla,inicio,fin);        
        List<solicitudDtoObj> solicitudObj = new ArrayList<solicitudDtoObj>();

        solicitudDtoObj solicitudDtoObj; 
        for(int i=0; i<eventos.size();i++) {
        	solicitudDtoObj = new solicitudDtoObj();
						
			solicitudDtoObj.setEvento(evento(eventos,i,""));
			solicitudDtoObj.setIdAmbiente(eventos.get(i).getIdAmbiente());
			solicitudDtoObj.setAmbiente("");
			solicitudDtoObj.setServicio("");
			for(int j=0;j<solicitudes.size();j++) {
        		if(solicitudes.get(j).getIdEvento().longValue()==eventos.get(i).getId().longValue()) {
        			solicitudDtoObj.setIdSolicitud(solicitudes.get(j).getId());
        			solicitudDtoObj.setCite(solicitudes.get(j).getCite());
        			solicitudDtoObj.setFecha(solicitudes.get(j).getFecha());
        			solicitudDtoObj.setIdServicio(solicitudes.get(j).getIdServicio());
        			solicitudDtoObj.setHojaRuta(solicitudes.get(j).getHojaRuta()); 
        			solicitudDtoObj.setCifResponsable(solicitudes.get(j).getCifResponsable());
        			solicitudDtoObj.setDetalle(solicitudes.get(j).getDetalle());
        			solicitudDtoObj.setGestion(solicitudes.get(j).getGestion());
        			
        			break;
        		}
        	}
        	solicitudObj.add(solicitudDtoObj);
        	
        }
        
        for(int i=0;i<solicitudObj.size();i++) {
        	for(int j=0;j<ambientes.size();j++) {
        		if(solicitudObj.get(i).getIdAmbiente().longValue()==ambientes.get(j).getId().longValue()) {
        			solicitudObj.get(i).setAmbiente(ambientes.get(j).getNombre());
        			solicitudObj.get(i).getEvento().setAmbiente(ambientes.get(j).getNombre());
        			break;
        		}
        	}
        }
        
        for(int i=0;i<solicitudObj.size();i++) {
        	for(int j=0;j<servicios.size();j++) {
        		if(solicitudObj.get(i).getIdServicio().longValue()== servicios.get(j).getId().longValue()) {
        			solicitudObj.get(i).setServicio(servicios.get(j).getDetalle());
        			break;
        		}
        	}
        }
        
        return(solicitudObj);
    }
    
    private String cite(int gestion) {
    	
    	List<solicitudModel>cite = this.solicitudDao.getSolicitudGestion(gestion);
    	String numero=""+cite.size()+1;
    	if(cite.size()<10)
    		numero="00"+(cite.size()+1);
    	if(cite.size()>9 && cite.size()<99)
    		numero="0"+(cite.size()+1);
    	return numero;
    }
    private eventoDtoObj evento(List<eventoModel> eventos,int i,String ambiente) {
    	
    	
    	List<servicioDtoResponse> servicios = this.servicioDao.getServicio(eventos.get(i).getIdAmbiente()).stream()
				.map(servicio->this.modelMapper.map(servicio, servicioDtoResponse.class))
				.collect(Collectors.toList());
    	
    	
    	eventoDtoObj eventoDtoObj = new eventoDtoObj();
		eventoDtoObj.setId(eventos.get(i).getId());
		eventoDtoObj.setNombre(eventos.get(i).getNombre());
		eventoDtoObj.setDetalle(eventos.get(i).getDetalle());
		eventoDtoObj.setFechaInicio(eventos.get(i).getFechaInicio());
		eventoDtoObj.setFechaFin(eventos.get(i).getFechaFin());
		eventoDtoObj.setHoraInicio(eventos.get(i).getHoraInicio()); 
		eventoDtoObj.setHoraFin(eventos.get(i).getHoraFin());
		
		eventoDtoObj.setAmbiente(ambiente);
		
		eventoDtoObj.setImagen(eventos.get(i).getImagen());
		eventoDtoObj.setFecha(eventos.get(i).getFecha());
		eventoDtoObj.setFechaE(eventos.get(i).getFechae()); 
		eventoDtoObj.setServicios(servicios);
		
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
		
		return(eventoDtoObj);
    }
    
}
