package com.example.fhceegovfsra.dao;

import com.example.fhceegovfsra.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
}
