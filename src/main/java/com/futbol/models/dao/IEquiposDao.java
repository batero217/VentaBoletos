package com.futbol.models.dao;
import org.springframework.data.repository.CrudRepository;

import com.futbol.models.entities.Equipos;


public interface IEquiposDao extends CrudRepository<Equipos, Long> {

}
