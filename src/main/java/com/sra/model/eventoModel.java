package com.sra.model;

import java.util.List;

public class eventoModel {
	
	
	private Long cif;
	private Long ambiente;
	private String referencia;
	private String detalle;
	private String fecha;
	private String horai;
	private String horaf;
	private String fechaActual;
	private List<String>requerimiento;
	
	
	
	public Long getCif() {
		return cif;
	}
	public void setCif(Long cif) {
		this.cif = cif;
	}
	public Long getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(Long ambiente) {
		this.ambiente = ambiente;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFehca(String fecha) {
		this.fecha = fecha;
	}
	public String getHorai() {
		return horai;
	}
	public void setHorai(String horai) {
		this.horai = horai;
	}
	public String getHoraf() {
		return horaf;
	}
	public void setHoraf(String horaf) {
		this.horaf = horaf;
	}
	public List<String> getRequerimiento() {
		return requerimiento;
	}
	public void setRequerimiento(List<String> requerimiento) {
		this.requerimiento = requerimiento;
	}
	public String getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(String fechaActual) {
		this.fechaActual = fechaActual;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
