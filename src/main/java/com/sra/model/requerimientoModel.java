package com.sra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="requerimiento")
public class requerimientoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	@Column
	private String _01cite;
	
	@Column
	private String _02detalle;
	
	@Column
	private int _03hora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String get_01cite() {
		return _01cite;
	}

	public void set_01cite(String _01cite) {
		this._01cite = _01cite;
	}

	public String get_02detalle() {
		return _02detalle;
	}

	public void set_02detalle(String _02detalle) {
		this._02detalle = _02detalle;
	}

	public int get_03hora() {
		return _03hora;
	}

	public void set_03hora(int _03hora) {
		this._03hora = _03hora;
	}
	
	
}
