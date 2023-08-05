package com.secure.horizon.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ContactRowMapper implements RowMapper<Contacto> {

	@Override
	public Contacto mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Contacto(rs.getInt("id"), rs.getDate("createAt"), rs.getString("userName"),
				rs.getString("message"));
	}

}
