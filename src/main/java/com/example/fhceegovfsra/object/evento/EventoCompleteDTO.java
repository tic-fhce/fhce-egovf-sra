package com.example.fhceegovfsra.object.evento;

public class EventoCompleteDTO {
  private long idEvento;
  private String cite;
  private String referencia;
  private String hojaRuta;

  public EventoCompleteDTO() {
  }

  public EventoCompleteDTO(long idEvento, String cite, String referencia, String hojaRuta) {
    this.idEvento = idEvento;
    this.cite = cite;
    this.referencia = referencia;
    this.hojaRuta = hojaRuta;
  }

  public long getIdEvento() {
    return idEvento;
  }

  public void setIdEvento(long idEvento) {
    this.idEvento = idEvento;
  }

  public String getCite() {
    return cite;
  }

  public void setCite(String cite) {
    this.cite = cite;
  }

  public String getReferencia() {
    return referencia;
  }

  public void setReferencia(String referencia) {
    this.referencia = referencia;
  }

  public String getHojaRuta() {
    return hojaRuta;
  }

  public void setHojaRuta(String hojaRuta) {
    this.hojaRuta = hojaRuta;
  }

}
