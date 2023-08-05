package com.secure.horizon.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsersRowMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new Usuario(rs.getInt("id"), rs.getString("userName"),
				rs.getString("run"), rs.getDate("birthDate"));
	}
	

}
