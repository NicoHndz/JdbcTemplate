package com.secure.horizon.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.secure.horizon.model.Capacitacion;
import com.secure.horizon.model.TrainingRowMapper;

@Repository
public class TrainingsDaoImpl implements TrainingsDAO {
	private final JdbcTemplate jdbcTemplate;

	public TrainingsDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Capacitacion> findAll() {
		String sql = """
				SELECT id, runCliente, fecha, hora, lugar, duracion, cantidadAsistentes
				FROM trainings""";
		return jdbcTemplate.query(sql, new TrainingRowMapper());
	}

	@Override
	public int addTraining(Capacitacion capacitacion) {
		String sql = """
				INSERT into trainings(runCliente, fecha, hora, lugar, duracion, cantidadAsistentes) VALUES(?,?,?,?,?,?)""";
		return jdbcTemplate.update(sql, capacitacion.getRunCliente(), capacitacion.getFecha(), capacitacion.getHora(),
				capacitacion.getLugar(), capacitacion.getDuracion(), capacitacion.getCantidadAsistentes());
	}

	@Override
	public Optional<Capacitacion> findById(int id) {
		String sql = """
				SELECT id, runCliente, fecha, hora, lugar, duracion, cantidadAsistentes
				FROM trainings WHERE id = ?""";
		return jdbcTemplate.query(sql, new TrainingRowMapper(), id).stream().findFirst();
	}

	@Override
	public int deleteTraining(int id) {
		String sql = """
				DELETE FROM trainings
				WHERE id = ?""";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public int updateTraining(int id, Capacitacion capacitacion) {
		String sql = """
				UPDATE trainings SET runCliente=?, fecha=?, hora=?, lugar=?, duracion=?, cantidadAsistentes=?
				WHERE id = ?""";
		return jdbcTemplate.update(sql, capacitacion.getRunCliente(), capacitacion.getFecha(), capacitacion.getHora(),
				capacitacion.getLugar(), capacitacion.getDuracion(), capacitacion.getCantidadAsistentes(), id);
	}
}
