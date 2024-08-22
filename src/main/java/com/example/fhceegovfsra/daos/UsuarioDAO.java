package com.example.fhceegovfsra.daos;

import com.example.fhceegovfsra.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
}