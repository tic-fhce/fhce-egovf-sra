package com.example.fhceegovfsra.models;

import jakarta.persistence.*;

@Entity
@Table(name = "certificados")
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_certificado", unique = true, nullable = false)
    private Long id_certificado;

    @Column(name = "_01id_evento")
    private Long id_evento;

    @Column(name = "_02carga_horaria")
    private int carga_horaria;

    @Column(name = "_03tipo")
    private String tipo;

    @Column(name = "_04descripcion")
    private String descripcion;

    @Column(name = "_05estado")
    private int estado;

    @Column(name = "_06modelo")
    private String modelo;


    public Certificado(Long id_certificado, Long id_evento, int carga_horaria, String tipo, String descripcion, int estado, String modelo) {
        this.id_certificado = id_certificado;
        this.id_evento = id_evento;
        this.carga_horaria = carga_horaria;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.modelo = modelo;
    }

    public Certificado() {
    }

    public Long getId_certificado() {
        return id_certificado;
    }

    public void setId_certificado(Long id_certificado) {
        this.id_certificado = id_certificado;
    }

    public Long getId_evento() {
        return id_evento;
    }

    public void setId_evento(Long id_evento) {
        this.id_evento = id_evento;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
