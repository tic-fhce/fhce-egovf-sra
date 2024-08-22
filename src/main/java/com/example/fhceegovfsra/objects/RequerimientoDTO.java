package com.example.fhceegovfsra.objects;

public class RequerimientoDTO {

    private Long id;
    private String cite;
    private String detalle;
    private int estado;

    public RequerimientoDTO(Long id, String cite, String detalle, int estado) {
        this.id = id;
        this.cite = cite;
        this.detalle = detalle;
        this.estado = estado;
    }

    public RequerimientoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
