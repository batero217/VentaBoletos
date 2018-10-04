package com.futbol.models.services;

import java.util.List;

import com.futbol.models.entities.Equipos;

public interface IEquiposService {
	 public List<Equipos> findAll();
		
		public void save(Equipos EQUIPOS);
		
		public Equipos findOne(Long eqID);
		
		public void delete(Long eqID);

}
