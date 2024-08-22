package com.example.fhceegovfsra.models;


import jakarta.persistence.*;

@Entity
@Table(name = "ambientes")
public class Ambiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ambiente", unique = true, nullable = false)
    private Long id_ambiente;

    @Column(name = "_01nombre")
    private String nombre;

    @Column(name = "_02estado")
    private int estado;
    public Ambiente(Long id_ambiente, String nombre, int estado) {
        this.id_ambiente = id_ambiente;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Ambiente() {
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Long getId_ambiente() {
        return id_ambiente;
    }

    public void setId_ambiente(Long id_ambiente) {
        this.id_ambiente = id_ambiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
