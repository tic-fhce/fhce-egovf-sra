package com.sra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sra.dao.reservaDAO;
import com.sra.model.reservaModel;

@RestController
@RequestMapping("fhce-egovf-even/evento") //develop
//@RequestMapping("reserva") // produccion
//@CrossOrigin("urlcliente/")
@CrossOrigin("http://192.168.31.45:8081/")

public class reservaController {
	@Autowired
	private reservaDAO reservadao;
	
	@PostMapping("/registrar")//registrar
	public void registrar(@RequestBody reservaModel reservaModel ) {
		reservadao.save(reservaModel);
	}
	
	@GetMapping("/listar")//listar
	public List<reservaModel> listar(){
		return (reservadao.findAll());
	}

	@GetMapping("/listarCif") //buscar en fecha 
	public List<reservaModel>listaCif(@RequestParam (value="cif") Long cif){
		return(reservadao.getCif(cif));
	}
	
	@GetMapping("/buscar") //buscar en fecha 
	public List<reservaModel>listaFecha(@RequestParam (value="fecha") String fecha){
		return(reservadao.fecha(fecha));
	}
	
	@GetMapping("/estado")
	public List<reservaModel>listaEstado(@RequestParam (value="estado") int estado){
		return(reservadao.estado(estado));
	}

}
