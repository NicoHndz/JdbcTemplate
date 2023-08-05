package com.secure.horizon.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.secure.horizon.model.Usuario;
import com.secure.horizon.model.UsersRowMapper;

@Repository
public class UsersDaoImpl implements UsersDAO {
	private final JdbcTemplate jdbcTemplate;

	public UsersDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Usuario> findAll() {
		String sql = """
				SELECT id, userName, run, birthDate
				FROM users""";
		return jdbcTemplate.query(sql, new UsersRowMapper());
	}

	@Override
	public int addUser(Usuario usuario) {
		String sql = """
				INSERT into users(userName, run, birthDate) VALUES (?,?,?)""";
		return jdbcTemplate.update(sql, usuario.getNombreUsuario(), usuario.getRun(), usuario.getFechaNacimiento());
	}

	@Override
	public Optional<Usuario> findById(int id) {
		String sql = """
				SELECT id, userName, run, birthDate
				FROM users WHERE id = ?""";
		return jdbcTemplate.query(sql, new UsersRowMapper(), id).stream().findFirst();
	}

	@Override
	public int deleteUser(int id) {
		String sql = """
				DELETE FROM users
				WHERE id = ?""";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public int updateUser(int id, Usuario usuario) {
		String sql = """
				UPDATE users SET userName=?, run=?, birthDate=?
				WHERE id=?""";
		return jdbcTemplate.update(sql, usuario.getNombreUsuario(), usuario.getRun(), usuario.getFechaNacimiento(), id);
	}
}
