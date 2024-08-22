package com.example.fhceegovfsra.objects;

public class AmbienteDTO {

    private Long id_ambiente;
    private String nombre;
    private int estado;

    public AmbienteDTO(Long id, String nombre, int estado) {
        this.id_ambiente = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public AmbienteDTO() {
    }

    public Long getId_ambiente() {
        return id_ambiente;
    }

    public void setId_ambiente(Long id) {
        this.id_ambiente = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
