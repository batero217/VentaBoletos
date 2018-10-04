package com.futbol.models.services;

import java.util.List;

import com.futbol.models.entities.Estadio;

public interface IEstadioService {

    public List<Estadio> findAll();
	
	public void save(Estadio estadio);
	
	public Estadio findOne(Long estid);
	
	public void delete(Long estid);
}
