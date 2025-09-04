package com.fhce.sra.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.sra.dto.solicitudDtoObj;
import com.fhce.sra.dto.solicitudDtoRequest;
import com.fhce.sra.dto.solicitudDtoResponse;
import com.fhce.sra.service.solicitudService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fhce-egovf-sra/solicitud")
@RequiredArgsConstructor
public class solicitudController {
	
	private final solicitudService solicitudService;
	
	@GetMapping("/getLista")
    public ResponseEntity<List<solicitudDtoObj>> getLista(@RequestParam (value="gestion") int gestion,@RequestParam (value="mes") int mes) {
        try {
			return new ResponseEntity<>(this.solicitudService.getLista(gestion,mes),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	@GetMapping("/getListaUsuario")
    public ResponseEntity<List<solicitudDtoObj>> getListaUsuario(@RequestParam (value="gestion") int gestion,@RequestParam (value="mes") int mes,@RequestParam (value="sigla") String sigla) {
        try {
			return new ResponseEntity<>(this.solicitudService.getListaUsuario(gestion,mes,sigla),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@GetMapping("/getListaSolicitud")
    public ResponseEntity<List<solicitudDtoResponse>> getListaSolicitud() {
        try {
			return new ResponseEntity<>(this.solicitudService.getListaSolicitud(),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@GetMapping("/getSolicitudes")
    public ResponseEntity<List<solicitudDtoObj>> getSolicitudes(@RequestParam (value="estado") int estado) {
        try {
			return new ResponseEntity<>(this.solicitudService.getSolicitudes(estado),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	@GetMapping("/getSolicitudesUnidad")
    public ResponseEntity<List<solicitudDtoObj>> getSolicitudesUnidad(@RequestParam (value="estado") int estado, @RequestParam (value="unidad") String unidad) {
        try {
			return new ResponseEntity<>(this.solicitudService.getSolicitudesUnidad(estado,unidad),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	@GetMapping("/getSolicitudesEventos")
    public ResponseEntity<List<solicitudDtoObj>> getSolicitudesEventos() {
        try {
			return new ResponseEntity<>(this.solicitudService.getSolicitudesEventos(),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	@GetMapping("/getSolicitudesEventosUnidad")
    public ResponseEntity<List<solicitudDtoObj>> getSolicitudesEventosUnidad(@RequestParam (value="unidad") String unidad) {
        try {
			return new ResponseEntity<>(this.solicitudService.getSolicitudesEventosUnidad(unidad),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@PostMapping("/addSolicitud")
    public ResponseEntity<solicitudDtoResponse> addSolicitud(@RequestBody solicitudDtoRequest solicitudDtoRequest) {
        try {
			return new ResponseEntity<>(this.solicitudService.addSolicitud(solicitudDtoRequest),HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    @PutMapping("/updateSolicitud")
    public ResponseEntity<solicitudDtoResponse> updateSolicitud(@RequestBody solicitudDtoResponse solicitudDtoResponse) {
        try {
			return new ResponseEntity<>(this.solicitudService.updateSolicitud(solicitudDtoResponse),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
