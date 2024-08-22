package com.example.fhceegovfsra.objects;

public class CertificadoDTO {
    private Long id_certificado;
    private Long id_evento;
    private int carga_horaria;
    private String tipo;
    private String descripcion;
    private int estado;
    private String modelo;

    public CertificadoDTO(Long id_certificado, Long id_evento, int carga_horaria, String tipo, String descripcion, int estado, String modelo) {
        this.id_certificado = id_certificado;
        this.id_evento = id_evento;
        this.carga_horaria = carga_horaria;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.modelo = modelo;
    }

    public CertificadoDTO() {
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
