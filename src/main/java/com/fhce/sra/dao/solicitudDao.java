package com.fhce.sra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fhce.sra.model.solicitudModel;

public interface solicitudDao extends JpaRepository<solicitudModel, Long>{
	
	@Query(value = "select * from solicitud where _08gestion=?",nativeQuery=true)
	List<solicitudModel> getSolicitudGestion(int gestion);
	
	@Query(value = "select * from solicitud where _05hojaruta LIKE ?",nativeQuery=true)
	List<solicitudModel> getSolicitudHr(String hojaRuta);
	
	@Query(value = "select * from solicitud where id=?",nativeQuery=true)
	solicitudModel getSolicitud(Long id);
	
	

}
