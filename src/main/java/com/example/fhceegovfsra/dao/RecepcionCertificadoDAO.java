package com.example.fhceegovfsra.dao;

import com.example.fhceegovfsra.model.RecepcionCertificado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecepcionCertificadoDAO extends JpaRepository<RecepcionCertificado, Long> {
  // @Query("SELECT new
  // com.example.fhceegovfsra.objects.responses.UsuarioCertificadoResponse(c.titulo,
  // c.tipo, c.carga_horaria) FROM RecepcionCertificado r JOIN Certificado c ON
  // r.id_certificado = c.id_certificado WHERE r.cif = :cif")
  // List<UsuarioCertificadoResponse> findByCif(@Param("cif") Long cif);
  @Query("SELECT r FROM RecepcionCertificado r WHERE r.cif = :cif")
  List<RecepcionCertificado> findByCif(Long cif);
}
