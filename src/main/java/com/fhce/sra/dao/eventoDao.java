package com.fhce.sra.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fhce.sra.model.eventoModel;

public interface eventoDao extends JpaRepository<eventoModel, Long>{
	@Query(value = "select * from evento where id=?",nativeQuery=true)
	eventoModel getEvento(Long idEvento);
	
	@Query(value = "select * from evento where _07estado=?",nativeQuery=true)
	List<eventoModel> getEventoEstado(int estado);
	
	@Query(value = "select * from evento where _07estado=? and _13unidad=? and _03start>= ?",nativeQuery=true)
	List<eventoModel> getEventoEstadoUnidad(int estado,String unidad, LocalDate inicio);
	
	@Query(value = "select * from evento where _03start>= ? and _04end<=?",nativeQuery=true)
	List<eventoModel> getFecha(String inicio,String fin);
	
	@Query(value = "select * from evento where _13unidad=?",nativeQuery=true)
	List<eventoModel> getUnidad(String unidad);
	
	@Query(value = "select * from evento where _03start>= ?",nativeQuery=true)
	List<eventoModel> getFecha(LocalDate inicio);
	
	@Query(value = "select * from evento where _13unidad=? and _03start>= ? and _04end<=?",nativeQuery=true)
	List<eventoModel> getEventoUnidad(String unidad,String inicio,String fin);

}
