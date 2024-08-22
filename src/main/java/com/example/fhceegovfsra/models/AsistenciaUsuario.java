package com.example.fhceegovfsra.models;

import jakarta.persistence.*;

@Entity
@Table(name = "asiste")
public class AsistenciaUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia_usuario", unique = true, nullable = false)
    private Long id_asistencia_usuario;

    @Column(name = "_01cif")
    private Long cif;
    @Column(name = "02_id_evento")
    private Long id_evento;

    public AsistenciaUsuario(Long id_asistencia_usuario, Long cif, Long id_evento) {
        this.id_asistencia_usuario = id_asistencia_usuario;
        this.cif = cif;
        this.id_evento = id_evento;
    }

    public AsistenciaUsuario() {
    }

    public Long getId_asistencia_usuario() {
        return id_asistencia_usuario;
    }

    public void setId_asistencia_usuario(Long id_asistencia_usuario) {
        this.id_asistencia_usuario = id_asistencia_usuario;
    }

    public Long getCif() {
        return cif;
    }

    public void setCif(Long cif) {
        this.cif = cif;
    }

    public Long getId_evento() {
        return id_evento;
    }

    public void setId_evento(Long id_evento) {
        this.id_evento = id_evento;
    }
}
