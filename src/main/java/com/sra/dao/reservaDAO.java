package com.sra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sra.model.reservaModel;

public interface reservaDAO extends JpaRepository<reservaModel,Long>{
	
	//List<reservaModel> fechas(String _2fecha_reserva);
	//List<reservaModel> findBy_2fecha_reserva(String _2fecha_reserva);
	@Query(value = "select * from reserva where _2fecha_reserva = ?",nativeQuery=true)
	List<reservaModel>fecha(String fecha);
	
	@Query(value="select * from reserva where _8estado=?",nativeQuery=true)
	List<reservaModel>estado(int estado);
	
	@Query(value="select * from reserva where _01cif=?",nativeQuery=true)
	List<reservaModel>getCif(Long cif);
	
	@Query(value="select * from reserva where _05fecha_reserva_gestion=?",nativeQuery=true)
	List<reservaModel>getCite(int gestion);
	
	

}
