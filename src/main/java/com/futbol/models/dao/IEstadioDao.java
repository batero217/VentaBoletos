package com.futbol.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.futbol.models.entities.Estadio;

public interface IEstadioDao extends CrudRepository<Estadio, Long> {

	//CrudRepository implementa todas las operaciones basicas de un crud.
}
