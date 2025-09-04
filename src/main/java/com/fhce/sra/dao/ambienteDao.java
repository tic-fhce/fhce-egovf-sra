package com.fhce.sra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fhce.sra.model.ambienteModel;

public interface ambienteDao extends JpaRepository<ambienteModel, Long> {
	@Query(value = "select * from ambiente where id=?",nativeQuery=true)
	ambienteModel getAmbiente(Long idambiente);

}
