package com.secure.horizon;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secure.horizon.dao.TrainingsDAO;
import com.secure.horizon.model.Capacitacion;

@RestController
@RequestMapping("api/capacitaciones")
public class TrainingControl {
	private final TrainingsDAO trainingsDao;

	public TrainingControl(TrainingsDAO trainingsDao) {
		this.trainingsDao = trainingsDao;
	}

	@PostMapping("/add")
	public void addUser(@Validated @RequestBody Capacitacion capacitacion) {
		trainingsDao.addTraining(capacitacion);
	}

	@GetMapping("/all")
	public List<Capacitacion> findAll() {
		return trainingsDao.findAll();
	}

	@PutMapping("/update/{id}")
	public int updateTraining(@Validated @RequestBody Capacitacion capacitacion, @PathVariable("id") int id) {
		return trainingsDao.updateTraining(id, capacitacion);
	}

	@GetMapping("/delete/{id}")
	public int deleteTraining(@PathVariable("id") int id) {
		return trainingsDao.deleteTraining(id);
	}

	@GetMapping("/{id}")
	public Capacitacion findById(@PathVariable("id") int id) {
		return trainingsDao.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
	}
}
