package com.example.fhceegovfsra.object.evento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoCompleteDTO {
  private long idEvento;
  private String cite;
  private String referencia;
  private String hojaRuta;

}
