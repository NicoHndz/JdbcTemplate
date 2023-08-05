package com.secure.horizon.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrainingRowMapper implements RowMapper<Capacitacion>{

	@Override
	public Capacitacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Capacitacion(rs.getInt("id"), rs.getString("runCliente"), rs.getDate("fecha"), rs.getString("hora"), 
				rs.getString("lugar"), rs.getString("duracion"), rs.getInt("cantidadAsistentes"));
	}
	
	
	
}
