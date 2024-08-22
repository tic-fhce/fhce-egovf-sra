package com.example.fhceegovfsra.daos;

import com.example.fhceegovfsra.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoDAO extends JpaRepository<Evento, Long> {
}