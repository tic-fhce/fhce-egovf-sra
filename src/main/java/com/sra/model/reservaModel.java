package com.sra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
public class reservaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	@Column
	private Long _01cif;
	
	@Column
	private String _02cite;
	
	@Column
	private String _03referencia;
	
	@Column
	private String _04fecha_reserva;
	
	@Column
	private int _05fecha_reserva_gestion;
	
	@Column
	private int _06fecha_reserva_mes;
	
	@Column
	private int _07fecha_reserva_dia;
	
	@Column
	private String _08hora_inicio;
	
	@Column 
	private String _09hora_fin;
	
	@Column
	private String _10detalle;
	
	@Column
	private String _11fecha;
	
	@Column
	private Long _12id_ambiente;
	
	@Column
	private int _13estado;
	
	
	@Column
	private String _14hoja;
	
	@Column
	private String _15has;
	
	@Column
	private String _16imagen;
	
	@Column
	private String _17fech;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long get_01cif() {
		return _01cif;
	}

	public void set_01cif(Long _01cif) {
		this._01cif = _01cif;
	}

	public String get_02cite() {
		return _02cite;
	}

	public void set_02cite(String _02cite) {
		this._02cite = _02cite;
	}

	public String get_03referencia() {
		return _03referencia;
	}

	public void set_03referencia(String _03referencia) {
		this._03referencia = _03referencia;
	}

	public String get_04fecha_reserva() {
		return _04fecha_reserva;
	}

	public void set_04fecha_reserva(String _04fecha_reserva) {
		this._04fecha_reserva = _04fecha_reserva;
	}

	public int get_05fecha_reserva_gestion() {
		return _05fecha_reserva_gestion;
	}

	public void set_05fecha_reserva_gestion(int _05fecha_reserva_gestion) {
		this._05fecha_reserva_gestion = _05fecha_reserva_gestion;
	}

	public int get_06fecha_reserva_mes() {
		return _06fecha_reserva_mes;
	}

	public void set_06fecha_reserva_mes(int _06fecha_reserva_mes) {
		this._06fecha_reserva_mes = _06fecha_reserva_mes;
	}

	public int get_07fecha_reserva_dia() {
		return _07fecha_reserva_dia;
	}

	public void set_07fecha_reserva_dia(int _07fecha_reserva_dia) {
		this._07fecha_reserva_dia = _07fecha_reserva_dia;
	}

	public String get_08hora_inicio() {
		return _08hora_inicio;
	}

	public void set_08hora_inicio(String _08hora_inicio) {
		this._08hora_inicio = _08hora_inicio;
	}

	public String get_09hora_fin() {
		return _09hora_fin;
	}

	public void set_09hora_fin(String _09hora_fin) {
		this._09hora_fin = _09hora_fin;
	}

	public String get_10detalle() {
		return _10detalle;
	}

	public void set_10detalle(String _10detalle) {
		this._10detalle = _10detalle;
	}

	public String get_11fecha() {
		return _11fecha;
	}

	public void set_11fecha(String _11fecha) {
		this._11fecha = _11fecha;
	}

	public Long get_12id_ambiente() {
		return _12id_ambiente;
	}

	public void set_12id_ambiente(Long _12id_ambiente) {
		this._12id_ambiente = _12id_ambiente;
	}

	public int get_13estado() {
		return _13estado;
	}

	public void set_13estado(int _13estado) {
		this._13estado = _13estado;
	}

	public String get_14hoja() {
		return _14hoja;
	}

	public void set_14hoja(String _14hoja) {
		this._14hoja = _14hoja;
	}

	public String get_15has() {
		return _15has;
	}

	public void set_15has(String _15has) {
		this._15has = _15has;
	}

	public String get_16imagen() {
		return _16imagen;
	}

	public void set_16imagen(String _16imagen) {
		this._16imagen = _16imagen;
	}

	public String get_17fech() {
		return _17fech;
	}

	public void set_17fech(String _17fech) {
		this._17fech = _17fech;
	}

}
