package com.example.fhceegovfsra.object.evento;

import java.util.List;

public class EventoConfirmDTO {
  private Long idEvento;
  private List<Long> idsRequerimientos;

  public EventoConfirmDTO() {
  }

  public EventoConfirmDTO(Long idEvento, List<Long> idsRequerimientos) {
    this.idEvento = idEvento;
    this.idsRequerimientos = idsRequerimientos;
  }

  public Long getIdEvento() {
    return idEvento;
  }

  public void setIdEvento(Long idEvento) {
    this.idEvento = idEvento;
  }

  public List<Long> getIdsRequerimientos() {
    return idsRequerimientos;
  }

  public void setIdsRequerimientos(List<Long> idsRequerimientos) {
    this.idsRequerimientos = idsRequerimientos;
  }

}
