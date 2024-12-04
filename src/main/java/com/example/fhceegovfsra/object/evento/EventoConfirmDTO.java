package com.example.fhceegovfsra.object.evento;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoConfirmDTO {
  private Long idEvento;
  private List<Long> idsRequerimientos;

}
