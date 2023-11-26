package com.sra.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sra.model.ambienteModel;

public interface ambienteDAO extends JpaRepository<ambienteModel,Long> {

}
