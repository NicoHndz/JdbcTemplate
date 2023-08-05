package com.secure.horizon.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.secure.horizon.model.Contacto;
import com.secure.horizon.model.ContactRowMapper;

@Repository
public class ContactDaoImpl implements ContactDAO {
	private final JdbcTemplate jdbcTemplate;

	public ContactDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Contacto> findAll() {
		String sql = """
				SELECT id, createAt, userName, message
				FROM contacts""";
		return jdbcTemplate.query(sql, new ContactRowMapper());
	}

	@Override
	public int addContact(Contacto contacto) {
		String sql = """
				INSERT into contacts(userName, message) VALUES (?,?)""";
		return jdbcTemplate.update(sql, contacto.getUserName(),contacto.getMessage());
	}

	@Override
	public Optional<Contacto> findById(int id) {
		String sql = """
				SELECT id, createAt, userName, message
				FROM contacts WHERE id = ?""";
		return jdbcTemplate.query(sql, new ContactRowMapper(),id).stream().findFirst();
	}

	@Override
	public int deleteContact(int id) {
		String sql = """
				DELETE FROM contacts
				WHERE id = ?""";
		return jdbcTemplate.update(sql,id);
	}

	@Override
	public int updateContact(int id, Contacto contacto) {
		String sql = """
				UPDATE contacts SET userName = ?, message = ?
				WHERE id = ? """;
		return jdbcTemplate.update(sql, contacto.getUserName(),contacto.getMessage(), id);
	}
}
