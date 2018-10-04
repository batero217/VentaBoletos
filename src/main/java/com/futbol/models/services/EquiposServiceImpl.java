package com.futbol.models.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futbol.models.dao.IEquiposDao;
import com.futbol.models.entities.Equipos;


@Service
public class EquiposServiceImpl implements IEquiposService {
	
	@Autowired
	private IEquiposDao equiposDao;
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Equipos> findAll() {		
		return (List<Equipos>) equiposDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Equipos findOne(Long eqID) {		
		return equiposDao.findById(eqID).orElse(null);
	}

	@Override
	@Transactional
	public void save(Equipos EQUIPOS) {
		equiposDao.save(EQUIPOS);
	}

	@Override
	@Transactional
	public void delete(Long eqID) {
		equiposDao.deleteById(eqID);
	}

}
