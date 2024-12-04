package com.example.fhceegovfsra.dao;

import com.example.fhceegovfsra.model.Requerimiento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequerimientoDAO extends JpaRepository<Requerimiento, Long> {
  // List<Requerimiento> findAllById(List<Long> ids);
}
