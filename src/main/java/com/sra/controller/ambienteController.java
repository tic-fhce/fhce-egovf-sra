package com.sra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sra.dao.ambienteDAO;
import com.sra.model.ambienteModel;

@RestController
@RequestMapping("fhce-egovf-even/ambiente") //develop
//@RequestMapping("ambiente") // produccion
//@CrossOrigin("urlcliente/")
@CrossOrigin("http://192.168.31.45:8081/")
public class ambienteController {
	@Autowired
	private ambienteDAO ambientedao;
	
	@PostMapping("/e5a25e888dde868cd815d51ee42bc511cd971233")//registrar
	public void registrar(@RequestBody ambienteModel ambiente ) {
		ambientedao.save(ambiente);
	}
	
	@GetMapping("/listar")//listar
	public List<ambienteModel> listar(){
		return (ambientedao.findAll());
	}

}
