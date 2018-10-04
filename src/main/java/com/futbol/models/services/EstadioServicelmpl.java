package com.futbol.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futbol.models.dao.IEstadioDao;
import com.futbol.models.entities.Estadio;

@Service
public class EstadioServicelmpl implements IEstadioService {

	@Autowired
	private IEstadioDao estadioDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Estadio> findAll() {		
		return (List<Estadio>) estadioDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Estadio findOne(Long estid) {		
		return estadioDao.findById(estid).orElse(null);
	}

	@Override
	@Transactional
	public void save(Estadio estadio) {
		estadioDao.save(estadio);
	}

	@Override
	@Transactional
	public void delete(Long estid) {
		estadioDao.deleteById(estid);
	}
}
