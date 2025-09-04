package com.fhce.sra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fhce.sra.model.servicioModel;

public interface servicioDao extends JpaRepository<servicioModel, Long>{
	
	@Query(value = "select * from servicio where _02idambiente=?",nativeQuery=true)
	List<servicioModel>getServicio(Long idambiente);

}
