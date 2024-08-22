package com.example.fhceegovfsra.models;

import jakarta.persistence.*;

@Entity
@Table(name = "requerimientos")
public class Requerimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_requerimiento", unique = true, nullable = false)
    private Long id_requerimiento;

    @Column(name = "_01cite")
    private String cite;

    @Column(name = "_02detalle")
    private String detalle;

    @Column(name = "_03estado")
    private int estado;


    public Requerimiento(Long id_requerimiento, String cite, String detalle, int estado) {
        this.id_requerimiento = id_requerimiento;
        this.cite = cite;
        this.detalle = detalle;
        this.estado = estado;
    }

    public Requerimiento() {
    }

    public Long getId_requerimiento() {
        return id_requerimiento;
    }

    public void setId_requerimiento(Long id_requerimiento) {
        this.id_requerimiento = id_requerimiento;
    }

    public String getCite() {
        return cite;
    }

    public void setCite(String cite) {
        this.cite = cite;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
