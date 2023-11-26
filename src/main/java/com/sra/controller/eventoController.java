package com.sra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sra.dao.requerimientoDAO;
import com.sra.dao.reservaDAO;
import com.sra.model.eventoModel;
import com.sra.model.requerimientoModel;
import com.sra.model.reservaModel;

@RestController
@RequestMapping("fhce-egovf-even/evento") //develop
//@RequestMapping("evento") // produccion
//@CrossOrigin("urlcliente/")
@CrossOrigin("http://192.168.31.45:8081/")
public class eventoController {
	
	@Autowired
	private reservaDAO reservaDAO;
	
	@Autowired
	private requerimientoDAO requerimientoDAO;
	
	@PostMapping("/agregar")
	public void agregar(@RequestBody eventoModel eventoModel) {
		
		reservaModel reservaModel= new reservaModel();
		requerimientoModel requerimientoModel = new requerimientoModel();
		int numero=0;
		reservaModel.set_01cif(eventoModel.getCif());
		
		reservaModel.set_03referencia(eventoModel.getReferencia());
		reservaModel.set_04fecha_reserva(eventoModel.getFecha());
		reservaModel.set_05fecha_reserva_gestion(Integer.parseInt(eventoModel.getFecha().substring(6,10)));
		reservaModel.set_06fecha_reserva_mes(Integer.parseInt(eventoModel.getFecha().substring(3, 5)));
		reservaModel.set_07fecha_reserva_dia(Integer.parseInt(eventoModel.getFecha().substring(0, 2)));
		numero=reservaDAO.getCite(reservaModel.get_05fecha_reserva_gestion()).size()+1;
		reservaModel.set_02cite("FHCE-UTIC-0"+numero+"/"+reservaModel.get_05fecha_reserva_gestion());
		reservaModel.set_08hora_inicio(eventoModel.getHorai());
		reservaModel.set_09hora_fin(eventoModel.getHoraf());
		reservaModel.set_10detalle(eventoModel.getDetalle());
		reservaModel.set_11fecha(eventoModel.getFechaActual());
		reservaModel.set_12id_ambiente(eventoModel.getAmbiente());
		reservaModel.set_13estado(0);
		reservaModel.set_14hoja("");
		reservaModel.set_15has("");
		reservaModel.set_16imagen("");
		reservaModel.set_17fech(eventoModel.getFechaActual());
		
		reservaDAO.save(reservaModel);
		int hora = Integer.parseInt(reservaModel.get_08hora_inicio().substring(0, 2)) + Integer.parseInt(reservaModel.get_09hora_fin().substring(0, 2));
		int minuto = Integer.parseInt(reservaModel.get_08hora_inicio().substring(3, 5)) + Integer.parseInt(reservaModel.get_09hora_fin().substring(3, 5));
		if(minuto>=60) {
			hora++;
		}
		
		requerimientoModel.set_01cite(reservaModel.get_02cite());
		requerimientoModel.set_03hora(hora);
		for(int i=0;i<eventoModel.getRequerimiento().size();i++) {
			requerimientoModel.set_02detalle(eventoModel.getRequerimiento().get(i));
			requerimientoDAO.save(requerimientoModel);
		}
		
	}

}
