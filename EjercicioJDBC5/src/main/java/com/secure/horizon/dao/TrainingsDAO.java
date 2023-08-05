package com.secure.horizon.dao;

import java.util.List;
import java.util.Optional;
import com.secure.horizon.model.Capacitacion;

public interface TrainingsDAO{

	List<Capacitacion> findAll();
	
	int addTraining(Capacitacion capacitacion);
	
	Optional<Capacitacion> findById(int id);
	
	int deleteTraining(int id);
	
	int updateTraining(int id, Capacitacion capacitacion);
}
